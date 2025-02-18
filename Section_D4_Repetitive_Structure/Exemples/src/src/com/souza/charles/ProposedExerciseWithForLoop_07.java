package src.com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 07: Create a program to read a positive integer N. 
The program should then display N lines on the screen, starting 
from 1 to N. For each line, show the line number, followed by the 
square and cube of the value, as illustrated in the example.

Examples:
________________________
Input         Output
________________________
  5            1  1  1  
               2  4  8
               3  9  27
               4  16 64
               5  25 125
________________________
*/
import java.util.Scanner;
public class ProposedExerciseWithForLoop_07 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int limit = scanner.nextInt();
    for (int i = 1; i <= limit; i++) {
      System.out.printf("%d %.0f %.0f%n", i, Math.pow(i, 2), Math.pow(i, 3));
    }
    scanner.close();
  }
}
