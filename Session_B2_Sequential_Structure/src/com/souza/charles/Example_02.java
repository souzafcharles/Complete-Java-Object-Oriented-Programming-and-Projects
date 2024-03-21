package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date:  March 14, 2024
*/

import java.util.Locale;

public class Example_02 {

	public static void main(String[] args) {

		int y = 2021;
		double x = 202.12021;

		System.out.println(y);
		System.out.println(x);

		Locale.setDefault(Locale.UK); // Manages the boundary definitions for the geographic region

		System.out.printf("%.2f%n", x); // formatted output
		System.out.printf("%.4f%n", x); // formatted output
		System.out.println("Result: " + x + " meters");
		System.out.printf("Result: %.2f meters%n", x); // formatted output

		String name = "Genésio Belizário";
		int age = 56;
		double monthlyIncome = 5010.0;

		System.out.printf("%s is %d years old and earns R$%.2f monthly.%n ", name, age, monthlyIncome); // formatted
																										// output
	}
}
