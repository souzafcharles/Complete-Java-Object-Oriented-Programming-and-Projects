package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: April 10, 2024
*/
/**
Example Exercise Problem 01: Create a program that reads integer numbers 
until a zero is encountered. Upon completion, display the sum of the numbers read.

Examples:
________________________
Input             Output
________________________
5                     11  
2               
4 
0               
________________________
*/
import java.util.Scanner;

public class ExampleExerciseProblem_01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		while (true) {
			int number = scanner.nextInt();
			if (number == 0) {
				break;
			}
			sum += number;
		}
		System.out.println(sum);
		scanner.close();

	}

}