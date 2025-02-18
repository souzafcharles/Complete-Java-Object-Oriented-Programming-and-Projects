package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Example Exercise Problem 01: Develop a program to read a temperature 
in Celsius and display the equivalent in Fahrenheit. Ask the user if 
they wish to repeat (y/n). If the user inputs "y", repeat the program.

Formula: F = 9C/5 + 32

Example:

Enter the temperature in Celsius: 30.0
Equivalent in Fahrenheit: 86.0
Would you like to repeat (y/n)? y

Enter the temperature in Celsius: 21.0
Equivalent in Fahrenheit: 69.8
Would you like to repeat (y/n)? y

Enter the temperature in Celsius: -10.5
Equivalent in Fahrenheit:13.1
Would you like to repeat (y/n)? n
*/
import java.util.Scanner;
public class ExampleExerciseProblemWithDoWhileLoop_01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char repeat;

    do {
      System.out.print("Enter the temperature in Celsius: ");
      double celsius = scanner.nextDouble();

      double fahrenheit = (9 * celsius / 5) + 32;

      System.out.printf("Equivalent in Fahrenheit: %.1f", fahrenheit);

      System.out.print("\nWould you like to repeat (y/n)? ");
      repeat = scanner.next().charAt(0);
    } while (repeat == 'y');
    scanner.close();
  }

}
