package src.com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 01: Read an integer value X (1 <= X <= 1000). Then display 
the odd numbers from 1 to X, one value per line, including X, if applicable.

Examples:
_______________
Input    Output
_______________
  8        1     
           3   
           5   
           7  
______________
*/
import java.util.Scanner;

public class ProposedExerciseWithForLoop_01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int X = scanner.nextInt();
    if (X >= 1 && X <= 1000) {
      for (int i = 1; i <= X; i++) {
        if (i % 2 != 0) {
          System.out.println(i);
        }
      }

    }
    scanner.close();
    
  }

}
