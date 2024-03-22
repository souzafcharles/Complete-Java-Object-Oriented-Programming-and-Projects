package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: March 22, 2024
*/
import java.util.Scanner;

public class Example_03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the exact time: ");
		int time = scanner.nextInt();
		if (time >= 00 && time < 12) {
			System.out.println("Good Morning!");
		} else if (time > 12 && time < 18) {
			System.out.println("Good Afternoon!");
		} else {
			System.out.println("Good Evening!");
		}
		scanner.close();
	}

}