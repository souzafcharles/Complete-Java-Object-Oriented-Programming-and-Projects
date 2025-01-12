package com.souza.charles.view.application;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 12, 2025
*/
import com.souza.charles.model.entities.Department;

public class App {

	public static void main(String[] args) {

		Department department = new Department(21, "Sports");
		System.out.println(department);
	}
}
