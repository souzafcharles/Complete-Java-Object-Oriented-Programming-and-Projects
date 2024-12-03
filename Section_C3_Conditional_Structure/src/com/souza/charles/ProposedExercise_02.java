package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 22, 2024
*/
/**
Exercise 02: Create a program to read an integer 
and determine whether it is even or odd.
*/
import java.util.Scanner;

public class ProposedExercise_02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.printf("The number %d is even.", number);
		} else {
			System.out.printf("The number %d is odd.", number);
		}
		scanner.close();
	}

}
