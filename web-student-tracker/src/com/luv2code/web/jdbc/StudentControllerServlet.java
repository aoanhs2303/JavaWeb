package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hapax.Template;
import hapax.TemplateDataDictionary;
import hapax.TemplateDictionary;
import hapax.TemplateException;
import hapax.TemplateLoader;
import hapax.TemplateResourceLoader;

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
//			listStudent(request, response);
		
				//TemplateLoader load resource

				TemplateLoader templateLoader = TemplateResourceLoader.create("com/luv2code/web/jdbc/");
				//Template load fileC:\Users\trann\eclipse-workspace\web-student-tracker\src\com\luv2code\web\jdbc
				Template template;
				try {
					//System.out.println(this.getClass().getClassLoader().getResource("com/luv2code/web/jdbc/list-student.xtm"));
					
					template = templateLoader.getTemplate("list-student.xtm");
					//Use TemplateDictionary to put to xtm
					TemplateDictionary templeDictionary = new TemplateDictionary();
					for (int i = 1; i <= 5; i++) {
						//Use TemplateDataDictionary to put data for section
						TemplateDataDictionary temp = templeDictionary.addSection("student");
						temp.setVariable("firstName", "" + i);
						temp.setVariable("lastName", "Life of PI");
						temp.setVariable("email", "Novel");
					}
					String data = template.renderToString(templeDictionary);
					System.out.println(data);
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		 
				
			
			
			
		
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
