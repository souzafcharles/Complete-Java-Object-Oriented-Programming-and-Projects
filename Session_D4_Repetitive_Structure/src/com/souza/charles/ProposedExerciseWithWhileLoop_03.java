package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: July 31, 2024
*/
/**
Exercise 03: A petrol station wishes to determine which of its products is 
preferred by its customers. Write an algorithm to read the type of fuel supplied 
(coded as follows: 1. Alcohol 2. Gasoline 3. Diesel 4. End). If the user enters an 
invalid code (outside the range of 1 to 4), a new code should be requested 
(until it is valid). The program will terminate when the code entered is the number 4. 
The message "THANK YOU" and the quantity of customers who filled up each 
type of fuel should be written, as in the example:

Examples:
_______________________
Input         Output
_______________________
  8         THANK YOU         
  1         Alcohol: 1         
  7          Gasoline: 2        
  2          Diesel: 0        
  2              
  4       
_______________________
*/
import java.util.Scanner;

public class ProposedExerciseWithWhileLoop_03 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int contAlcohol = 0;
    int contGasoline = 0;
    int contDiesel = 0;
    while (true) {
      int typeOfFuel = scanner.nextInt();
      if (typeOfFuel == 4) {
        break;
      } else if (typeOfFuel == 1) {
        contAlcohol++;
      } else if (typeOfFuel == 2) {
        contGasoline++;
      } else if (typeOfFuel == 3) {
        contDiesel++;
      } else {
        System.out.println("Type a valid code: 1. Alcohol; 2. Gasoline; 3. Diesel; 4. End");
      }
    }
    System.out.printf("THANK YOU\nAlcohol: %2d\nGasoline: %2d\nDiesel: %2d%n", contAlcohol++, contGasoline++, contDiesel++);
    scanner.close();
  }
}
