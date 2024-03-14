package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: January 23, 2024
*/

import java.util.Locale;

public class Example_01 {

	public static void main(String[] args) {
		
		int y = 32;
		double x = 10.35784;
		System.out.println(y);
		System.out.println(x);
		System.out.printf("%.2f%n", x);
		System.out.printf("%.4f%n", x);
		Locale.setDefault(Locale.UK);
		System.out.printf("%.4f%n", x);
		System.out.println("Result = " + x + " metres");
		System.out.printf("Result = %.2f metres%n", x);
		
		String name = "Epaminondas";
        int age = 34;
        double income = 4000.0;
        System.out.printf("%s is %d years old and received \u00A3 %.2f pounds%n", name, age, income);
    
	};
}
