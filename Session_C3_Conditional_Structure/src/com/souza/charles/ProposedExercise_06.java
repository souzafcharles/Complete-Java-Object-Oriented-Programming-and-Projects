package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 25, 2024
*/
/**
Exercise 06: You are required to create a program that reads any value 
and presents a message stating in which of the following intervals 
([0,25], [25,50], [50,75], [75,100]) this value is located. 
Clearly, if the value is not within any of these intervals, 
the message 'Out of range' should be printed.
*/
import java.util.Scanner;

public class ProposedExercise_06 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double value = scanner.nextDouble();
		if (value >= 0 && value <= 25) {
			System.out.println("Interval [0,25]");
		} else if (value >= 25 && value <= 50) {
			System.out.println("Interval [25,50]");
		} else if (value >= 50 && value <= 75) {
			System.out.println("Interval [50,75]");
		} else if (value >= 75 && value <= 100) {
			System.out.println("Interval [75,100]");
		} else {
			System.out.println("Out of range");
		}
		scanner.close();

	}

}
