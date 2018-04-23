package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/web_student_tracker","root","");  
			Statement stmt= con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from student");  
			while(rs.next()) {
				//retrieve data from result set row
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				//create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				System.out.println(firstName);
				// add it to the list of students
				students.add(tempStudent);
			}
				
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return students;
	}

	public void addStudent(Student student) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/web_student_tracker","root","");  
			PreparedStatement stmt= null;  
			//create SQL for insert
			String sql = "insert into student"
					   + "(first_name, last_name, email)"
					   + "value(?,?,?)";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			//set the param values for the student
			
			stmt.execute();
			
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
	}

	public  static Student getStudent(String theStudentId) {
		Student theStudent = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/web_student_tracker","root","");  
			int studentId = Integer.parseInt(theStudentId);
			PreparedStatement stmt= null;  
			//create SQL for insert
			String sql = "select * from student where id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			//set the param values for the student
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				
				//create student
				theStudent = new Student(studentId,firstName,lastName,email);
			}
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return theStudent;
	}

	public static void updateStudent(Student theStudent) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/web_student_tracker","root","");  
			PreparedStatement stmt= null;  
			//create SQL for insert
			String sql = "update student "
					   + "set first_name=?, last_name=?, email=? "
					   + "where id=?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, theStudent.getFirstName());
			stmt.setString(2, theStudent.getLastName());
			stmt.setString(3, theStudent.getEmail());
			stmt.setInt(4, theStudent.getId());
			//set the param values for the student
			
			stmt.execute();
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
	}

	public void deleteStudent(String theStudentId) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/web_student_tracker","root","");  
			int studentId = Integer.parseInt(theStudentId);
			PreparedStatement stmt= null;  
			//create SQL for insert
			String sql = "delete from student where id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			//set the param values for the student
			
			stmt.execute();
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
	}
}
