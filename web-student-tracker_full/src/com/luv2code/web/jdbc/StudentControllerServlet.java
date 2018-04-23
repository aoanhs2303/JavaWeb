package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDbUtil studentDbUtil;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			
		} catch(Exception e) {
			throw new ServletException();
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String theCommand = request.getParameter("command");
			if(theCommand == null) {
				theCommand = "LIST";
			}
			switch (theCommand) {
			case "LIST":
				listStudent(request, response);
				break;
			
			case "ADD": 
				addStudent(request, response);
				break;
				
			case "LOAD":
				loadStudent(request, response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
				
			case "DELETE":
				deleteStudent(request, response);
				break;
			default: listStudent(request, response);
			}	
//				//TemplateLoader load resource
//				studentDbUtil = new StudentDbUtil();
//				ArrayList<Student> students = (ArrayList<Student>)studentDbUtil.getStudents(); 
//				TemplateLoader templateLoader = TemplateResourceLoader.create("com/luv2code/web/jdbc/");
//				//Template load file
//				Template template;
//				try {
//					//System.out.println(this.getClass().getClassLoader().getResource("com/luv2code/web/jdbc/list-student.xtm"));
//					
//					template = templateLoader.getTemplate("list-student.xtm");
//					//Use TemplateDictionary to put to xtm
//					TemplateDictionary templeDictionary = new TemplateDictionary();
//					for (int i = 0; i < students.size(); i++) {
//						//Use TemplateDataDictionary to put data for section
//						TemplateDataDictionary temp = templeDictionary.addSection("student");
//						temp.setVariable("firstName", students.get(i).getFirstName());
//						temp.setVariable("lastName", students.get(i).getLastName());
//						temp.setVariable("email", students.get(i).getEmail());
//					}
//					String data = template.renderToString(templeDictionary);
//					response.getWriter().write(data);
//				} catch (TemplateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		//get Id
		String theStudentId = request.getParameter("studentId");
		//Call delete function from DB
		studentDbUtil.deleteStudent(theStudentId);
		//send them back to list
		try {
			listStudent(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		//read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		System.out.println(id);
		
		//create student object
		Student theStudent = new Student(id, firstName, lastName, email);
		
		//perform update on database
		StudentDbUtil.updateStudent(theStudent);
		
		//send them back to "lis student"
		try {
			listStudent(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	private void loadStudent(HttpServletRequest request, HttpServletResponse response) {
		//read student id from form data;
		String theStudentId = request.getParameter("studentId");
		
		//get student from db
		Student theStudent = StudentDbUtil.getStudent(theStudentId);
		
		//place student in request attriubute
		request.setAttribute("THE_STUDENT", theStudent);
		
		//send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-student-form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read data 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		//create student obj
		Student student = new Student(firstName,lastName,email);
		System.out.println(student);
		//add to DB
		studentDbUtil.addStudent(student);
		
		//back to list
		listStudent(request, response);
	}



	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get students from DB
		studentDbUtil = new StudentDbUtil();
		List<Student> students = studentDbUtil.getStudents(); 
		//add students to the request
		request.setAttribute("STUDENT_LIST", students);
		//
		//send JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);
	}


}
