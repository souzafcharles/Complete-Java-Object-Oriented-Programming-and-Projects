package com.souza.charles.app;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 03, 2024
*/
/**
Example Exercise Problem 01: Develop a program to read three integers and display the largest one on the screen.

Examples:
_________________________________
Input                      Output
_________________________________
Enter three numbers:         8
5
8
3             
________________________
*/
import java.util.Scanner;

public class ExampleExerciseProblemWithFunction_01 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter three numbers:");

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();

    if (a > b && a > c) {
      System.out.println("The highest number is: " + a);
    } else if (b > c) {
      System.out.println("The highest number is: " + b);
    } else {
      System.out.println("The highest number is: " + c);
    }

    scanner.close();
  }

}