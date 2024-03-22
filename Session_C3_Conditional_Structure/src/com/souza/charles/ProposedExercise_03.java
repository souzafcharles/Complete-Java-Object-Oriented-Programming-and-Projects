package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 22, 2024
*/
/**
Exercise 03: Read 2 integer values (A and B). 
Afterwards, the program should display a message 
'Are Multiples' or 'Are Not Multiples', indicating 
whether the values read are multiples of each other. 
Note: the numbers should be able to be entered in ascending or descending order.
*/
import java.util.Scanner;

public class ProposedExercise_03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		if (A % B == 0 || B % A == 0) {
			System.out.println("They are Multiples!");
		} else {
			System.out.println("They are not Multiples!"
					+ "");
		}
		scanner.close();
	}
}
