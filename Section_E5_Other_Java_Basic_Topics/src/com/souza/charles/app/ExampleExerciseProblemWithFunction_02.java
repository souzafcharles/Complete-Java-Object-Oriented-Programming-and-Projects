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
____________________________________
Input                       Output
____________________________________
Enter three numbers:      Highest: 8
5
8
3             
____________________________________
*/
import java.util.Scanner;

public class ExampleExerciseProblemWithFunction_02 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Use scanner instead of sc

    System.out.println("Enter three numbers:");

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();

    int highestValue = determineHighest(a, b, c);
    
    displayResult(highestValue);

    scanner.close();
  }

  public static int determineHighest(int x, int y, int z) {
    int highest; 

    if (x > y && x > z) {
      highest = x;
    } else if (y > z) {
      highest = y;
    } else {
      highest = z;
    }

    return highest;
  }

  public static void displayResult(int value) {
    System.out.println("Highest: " + value); 
  }
}