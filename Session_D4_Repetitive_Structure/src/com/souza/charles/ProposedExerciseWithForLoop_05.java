package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 05: Read a value N. Calculate and write its respective factorial. 
The factorial of N is defined as N×(N−1)×(N−2)×(N−3)×…×1. 
Note that, by definition, the factorial of 0 is 1.

Examples:
__________________________
Input               Output
__________________________
  4                   24   
  1                    1
  5                  120
  0                    1
__________________________
*/

import java.util.Scanner;

public class ProposedExerciseWithForLoop_05 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int factorial = 1;
		for (int i = 1; i <= N; i++) {
			factorial *= i;
		}
		
		System.out.println(factorial);
		scanner.close();

	}

}
