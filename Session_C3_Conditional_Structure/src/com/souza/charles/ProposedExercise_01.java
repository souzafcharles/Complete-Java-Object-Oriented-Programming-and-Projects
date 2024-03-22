package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 22, 2024
*/
/**
Exercise 01: Create a program to read an integer, and subsequently 
determine whether this number is negative or not.
*/
import java.util.Scanner;

public class ProposedExercise_01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if (number < 0) {
			System.out.println("The number is negative!");
		} else {
			System.out.println("The number is not negative!");
		}
		scanner.close();

	}

}
