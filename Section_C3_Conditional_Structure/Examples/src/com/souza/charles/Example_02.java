package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: March 22, 2024
*/
import java.util.Scanner;

public class Example_02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the exact time: ");
		int hour = scanner.nextInt();
		if (hour < 12) {
			System.out.println("Good morning!");
		} else {
			System.out.println("Good afternoon!");
		}
		scanner.close();
	}

}
