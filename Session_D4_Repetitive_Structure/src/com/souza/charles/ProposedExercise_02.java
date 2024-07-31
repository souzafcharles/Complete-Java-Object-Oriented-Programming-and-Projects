package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: July 31, 2024
*/
/**
Exercise 02: Write a program to read the coordinates (X, Y) of an 
indeterminate number of points in the Cartesian coordinate system. 
For each point, determine and output the quadrant to which it belongs. 
The algorithm should terminate when at least one of the two coordinates 
is NULL (in this case, without outputting any message):

Cartesian:

        |Y
 Second | First
-----------------X
 Third  | Fourth
        | 

Examples:
_____________________________________
Input X    Input Y        Output
_____________________________________
  2          2        First quadrant 
  3         -2        Fourth quadrant 
 -8         -1        Third quadrant
 -7         -1        Second quadrant
  0          2        
_____________________________________
*/
import java.util.Scanner;

public class ProposedExercise_02 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      int coordinateX = scanner.nextInt();
      int coordinateY = scanner.nextInt();
      if (coordinateX == 0 || coordinateY == 0) {
        break;
      } else if (coordinateX > 0 && coordinateY > 0) {
        System.out.println("First quadrant");
      } else if (coordinateX < 0 && coordinateY > 0) {
        System.out.println("Second quadrant");
      } else if (coordinateX < 0 && coordinateY < 0) {
        System.out.println("Third quadrant");
      } else {
        System.out.println("Fourth quadrant");
      }
    }

    scanner.close();
  }
}