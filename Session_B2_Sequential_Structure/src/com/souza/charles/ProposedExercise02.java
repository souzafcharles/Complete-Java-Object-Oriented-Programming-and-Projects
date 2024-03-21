package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 02: Write a program to read the value of the radius of a circle,
and then display the value of the area of this circle to four decimal places.
Area formula: area = π . radius^2 
Consider the value of π = 3.14159
*/
import java.util.Scanner;

public class ProposedExercise02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double pi = 3.14159;
		double radius = scanner.nextDouble();
		double area = pi * Math.pow(radius, 2);
		System.out.printf("Area: %.4f", area);
		scanner.close();
		
	}
	
}
