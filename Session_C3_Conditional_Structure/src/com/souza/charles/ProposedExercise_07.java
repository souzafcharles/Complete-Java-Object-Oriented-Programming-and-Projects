package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 26, 2024
*/
/**
Exercise 07: Read 2 values with one decimal place (x and y), 
which should represent the coordinates of a point on a plane. 
Then, determine which quadrant the point belongs to, or if 
it is on one of the Cartesian axes or at the origin (x = y = 0). 
If the point is at the origin, write the message "Origin". 
If the point is on one of the axes write "Axis X" or "Axis Y", 
depending on the situation.

    |y
 Q2 | Q1
---------x
 Q3 | Q4
    | 

Examples:
__________________________
Input x   Input y   Output
__________________________
  4.5      -2.2       Q4
  0.1       0.1       Q1
  0.0       0.0     Origin
 -2.2      -2.2       Q3
 -2.2       0.1       Q2
  0.0      -2.0     Axis Y
 -2.0       0.0     Axis X
__________________________
*/
import java.util.Scanner;

public class ProposedExercise_07 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double xValue = scanner.nextDouble();
		double yValue = scanner.nextDouble();
		if (xValue == 0 && yValue == 0) {
			System.out.println("Origin");
		} else if (xValue == 0.0) {
			System.out.println("Axis Y");
		} else if (yValue == 0.0) {
			System.out.println("Axis X");
		}else if (xValue > 0 && yValue > 0) {
			System.out.println("Q1");
		} else if (xValue < 0 && yValue > 0) {
			System.out.println("Q2");
		} else if (xValue < 0 && yValue < 0) {
			System.out.println("Q3");
		} else {
			System.out.println("Q4");
		}
		scanner.close();

	}

}
