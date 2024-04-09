package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: April 09, 2024
*/
/**
Example Exercise Problem 02: Create a program to read an integer value 
from 1 to 7 representing a day of the week (where 1 = Sunday, 2 = Monday, and so on). 
Display on the screen the corresponding day of the week, as shown in the examples:

Examples:
_______________________________________________
Input                       Output
_______________________________________________
1                Day of the week: Sunday     
4                Day of the week: Wednesday
9                Day of the week: Invalid value
_______________________________________________
*/
import java.util.Scanner;

public class ExampleExerciseProblem_02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String dayOfTheWeek;
		int numberOfTheWeek = scanner.nextInt();

		switch (numberOfTheWeek) {
		case 1:
			dayOfTheWeek = "Sunday";
			break;
		case 2:
			dayOfTheWeek = "Monday";
			break;
		case 3:
			dayOfTheWeek = "Tuesday";
			break;
		case 4:
			dayOfTheWeek = "Wednesday";
			break;
		case 5:
			dayOfTheWeek = "Thursday";
			break;
		case 6:
			dayOfTheWeek = "Friday";
			break;
		case 7:
			dayOfTheWeek = "Saturday";
			break;
		default:
			dayOfTheWeek = "Invalid value";
		}
		System.out.printf("Day of the week: %s", dayOfTheWeek);
		scanner.close();

	}
}