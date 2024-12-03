package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 19, 2024
*/
import java.util.Locale;

public class Exercise_01 {

	public static void main(String[] args) {

		String product1 = "Computer";
		String product2 = "Office desk";
		int age = 30;
		int code = 5290;
		char gender = 'F';
		double price1 = 2100.0;
		double price2 = 650.50;
		double measure = 53.234567;
		System.out.println("Products:");
		System.out.printf("%s, which price is $ %.2f", product1, price1);
		System.out.printf("\n%s, which price is $ %.2f", product2, price2);
		System.out.printf("\n\nRecord: %d years old, code %d and gender: %s ", age, code, gender);
		System.out.printf("\n\nMeasure with eight decimal place: %.8f", measure);
		System.out.printf("\nRouded (three decimal places): %.3f", measure);
		Locale.setDefault(Locale.US);
		System.out.printf("\nUS decimal point: %.3f", measure);

	}

}
