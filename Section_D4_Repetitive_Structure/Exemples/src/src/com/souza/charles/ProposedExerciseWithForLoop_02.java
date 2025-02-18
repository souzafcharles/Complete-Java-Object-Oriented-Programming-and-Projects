package src.com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 01, 2024
*/
/**
Exercise 02: Read an integer value N. This value represents the quantity of 
integer values X that will subsequently be read. Indicate how many of these 
X values fall within the interval [10, 20] and how many fall outside of this 
interval, presenting this information as demonstrated in the example 
(use the word "in" for within the interval, and "out" for outside the interval).

Examples:
_______________
Input    Output
_______________
   5      2 in    
  14      3 out    
 123           
  10         
 -25
  32  
_______________
*/
import java.util.Scanner;

public class ProposedExerciseWithForLoop_02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int limit = scanner.nextInt();
    int contIn = 0, contOut = 0;
    for (int i = 0; i < limit; i++) {
      int number = scanner.nextInt();
      if (number >= 10 && number <= 20) {
        contIn++;
      } else {
        contOut++;
      }
    }
    System.out.printf("In: %d\nOut: %d%n", contIn, contOut);
    scanner.close();
  }
}
