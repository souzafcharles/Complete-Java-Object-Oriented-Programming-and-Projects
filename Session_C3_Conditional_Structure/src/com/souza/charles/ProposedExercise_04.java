package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 22, 2024
*/
/**
Exercise 04: Read the start time and end time of a game. 
Then calculate the duration of the game, knowing that 
it may start on one day and end on another, 
with a minimum duration of 1 hour and a maximum of 24 hours.

*/
import java.util.Scanner;

public class ProposedExercise_04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int duration;
		int startTime = scanner.nextInt();
		int finalTime = scanner.nextInt();
		if (startTime < finalTime) {
			duration = finalTime - startTime;
		} else {
			duration = 24 - startTime + finalTime;
		}
		System.out.printf("The game lasted for %d hour(s).", duration);
		scanner.close();
	}
}
