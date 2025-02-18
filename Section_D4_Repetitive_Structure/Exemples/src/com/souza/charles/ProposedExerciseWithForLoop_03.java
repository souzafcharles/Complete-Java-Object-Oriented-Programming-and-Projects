package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 03: Read an integer value N, which represents the number of test 
cases that follow. Each test case consists of 3 real numbers, each with one 
decimal place. Present the weighted average for each of these sets of 3 values, 
where the first value has a weight of 2, the second value has a weight of 3, 
and the third value has a weight of 5.

Examples:
__________________________
Input               Output
__________________________
  3                  5.7   
  6.5 4.3 6.2        6.3  
  5.1 4.2 8.1        9.3    
  8.0 9.0 10.0        
__________________________
*/

import java.util.Scanner;
public class ProposedExerciseWithForLoop_03 {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        for (int i = 0; i < limit; i++) {
            double firstvalue = scanner.nextDouble();
            double secondvalue = scanner.nextDouble();
            double thirdvalue = scanner.nextDouble();
            double weightedAverage = (firstvalue * 2.0 + secondvalue * 3.0 + thirdvalue * 5.0) / (2.0 + 3.0 + 5.0);
            System.out.printf("%.1f%n", weightedAverage);
        }
        scanner.close();
    }
}
