package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: April 09, 2024
*/
/**
Example Exercise Problem 01: A telecommunications provider 
charges $50.00 for a basic plan that includes 100 minutes 
of phone usage. Each minute exceeding the 100-minute allowance 
costs $2.00. Develop a program to read the quantity of minutes 
consumed by a person and then display the amount to be paid.

Examples:
________________________
Input             Output
________________________
22                $50.00     
103               $56.00
________________________
*/
import java.util.Scanner;

public class ExampleExerciseProblem_01_Refactored {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double basicPlanCost = 50.00;
		int minutesConsumed = scanner.nextInt();
		double amountToBePaid = basicPlanCost + Math.max(0, (minutesConsumed - 100) * 2);
		System.out.printf("$ %.2f", amountToBePaid);
		scanner.close();
	}
}
