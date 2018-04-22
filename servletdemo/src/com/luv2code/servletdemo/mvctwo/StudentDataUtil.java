package com.luv2code.servletdemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	public static List<Student> getStudent() {
		//create empty list
		List<Student> students = new ArrayList<>(); 
		//add sample data
		students.add(new Student("Luc", "21", "luc97@gmail.com"));
		students.add(new Student("Lan", "31", "luc127@gmail.com"));
		students.add(new Student("Lien", "41", "luc12127@gmail.com"));
		//return the list
		return students;
	}
}
