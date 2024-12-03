package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: July 31, 2024
*/
/**
Exercise 01: Write a program that repeatedly prompts the user for a password 
until a valid one is entered. For each incorrect password entered, display 
the message "Invalid password". When the correct password is entered, display 
the message "Access granted" and terminate the program. Assume that the correct 
password is 2002.:

Examples:
______________________________
Input             Output
______________________________
2200         Invalid password  
1020         Invalid password  
2022         Invalid password
2002         Access allowed
______________________________
*/
import java.util.Scanner;

public class ProposedExerciseWithWhileLoop_01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final String correctPassword = "2002"; // Use a String for password comparison
    while (true) {
      String enteredPassword = scanner.nextLine();
      if (enteredPassword.equals(correctPassword)) {
        System.out.println("Access allowed");
        break;
      } else {
        System.out.println("Invalid password");
      }
    }

    scanner.close();
  }

}
