package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date:  March 19, 2024
*/

import java.util.Scanner;

public class Example_09 {

	public static void main(String[] args) {
		// Scanner is a class in java package used for obtaining 
		// the input of the primitive types.
		Scanner scanner = new Scanner(System.in);
		String scanner1, scanner2, scanner3;
		scanner1 = scanner.nextLine();
		scanner2 = scanner.nextLine();
		scanner3 = scanner.nextLine();
		System.out.println("Entered Data: ");
		System.out.println("Type: " + scanner1);
		System.out.println("Type: " + scanner2);
		System.out.println("Type: " + scanner3);
		scanner.close();
	}
}