package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 01: Write a program to read two integer values, 
and then display on the screen the sum of these numbers 
with an explanatory message.
*/
import java.util.Scanner;

public class ProposedExercise01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int number01 = scanner.nextInt();
		int number02 = scanner.nextInt();
		int sum = number01 + number02;
		System.out.println("SUM = " + sum);
		scanner.close();
		
	}
}
