package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 05: Write a program to read the code of item 1, 
the quantity of item 1, the unit value of each item 1, 
the code of item 2, the quantity of item 2, and the unit value of each item 2. 
Calculate and display the total amount to be paid.
*/
import java.util.Scanner;

public class ProposedExercise05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int item01 = scanner.nextInt();
		int quantityOfItem01 = scanner.nextInt();
		double unitValueEachItem01 = scanner.nextDouble();
		int item02 = scanner.nextInt();
		int quantityOfItem02 = scanner.nextInt();
		double unitValueEachItem02 = scanner.nextDouble();
		double totalAmount = (quantityOfItem01 * unitValueEachItem01) + (quantityOfItem02 * unitValueEachItem02);
		System.out.printf("The total amount to be paid $: %.2f", totalAmount);
		scanner.close();

	}
}
