package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 06: Read an integer N and calculate all its divisors.

Examples:
__________________________
Input               Output
__________________________
  6                   1   
                      2
                      3
                      6
__________________________
*/
import java.util.Scanner;
public class ProposedExerciseWithForLoop_06 {

	  public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);

	    int N = scanner.nextInt();

	    for (int i = 1; i <= N; i++) {

	      if (N % i == 0) {
	        System.out.println(i);
	      }

	    }
	    scanner.close();
	  }

}