package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date:  March 14, 2024
*/

import java.util.Scanner;

public class Example_08 {

	public static void main(String[] args) {
		// Scanner is a class in java package used for obtaining the input of the
		// primitive types.
		Scanner scanner = new Scanner(System.in);

		String text;

		text = scanner.next();

		System.out.println("You typed: " + text);

		scanner.close();
	}
}
