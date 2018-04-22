package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
