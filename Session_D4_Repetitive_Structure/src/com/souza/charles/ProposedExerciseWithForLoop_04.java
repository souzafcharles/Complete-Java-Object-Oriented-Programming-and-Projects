package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 04: Create a program to read a number N. Then, read N pairs of numbers 
and display the division of the first by the second. 
If the denominator is zero, display the message "impossible division".

Examples:
______________________________
Input        Output
______________________________
  3           -1.5  
  3  -2    impossible division  
 -8   0        0.0   
  0   8       
______________________________
*/
import java.util.Locale;
import java.util.Scanner;

public class ProposedExerciseWithForLoop_04 {

  public static void main(String[] args) {

	Locale.setDefault(Locale.UK);
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    for (int i = 0; i < N; i++) {
      double numerator = scanner.nextDouble();
      double denominator = scanner.nextDouble();

      if (denominator == 0) {
        System.out.println("impossible division");
      } else {
        double division = numerator / denominator;
        System.out.printf("%.1f", division);
      }

    }

    scanner.close();

  }

}