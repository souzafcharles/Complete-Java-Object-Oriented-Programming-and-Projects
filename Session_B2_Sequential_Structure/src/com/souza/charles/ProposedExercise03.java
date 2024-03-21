package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 03: Write a program to read four integer values A, B, C, and D. 
Then, calculate and show the difference between the product of A and B 
and the product of C and D according to the formula: 
DIFFERENCE = (A * B - C * D).
*/
import java.util.Scanner;

public class ProposedExercise03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		int D = scanner.nextInt();
		int DIFFERENCE = (A * B) - (C * D);
		System.out.println("DIFFERENCE: " + DIFFERENCE);
		scanner.close();
	
	}
	
}
