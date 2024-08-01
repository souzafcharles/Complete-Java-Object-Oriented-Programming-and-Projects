package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: July 31, 2024
*/
/**
Example Exercise Problem 01: Develop a program that reads an integer value N and then reads 
N integers. Finally, display the sum of the N integers read.

Examples:
________________________
Input             Output
________________________
3                     11  
5               
2 
4              
________________________
*/
import java.util.Scanner;

public class ExampleExerciseProblemWithForLoop_01 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int sum = 0;
    for (int i = 0; i < N; i ++) {
      int number = scanner.nextInt();
      sum += number;
    }
    System.out.println(sum);
    scanner.close();

  }

}