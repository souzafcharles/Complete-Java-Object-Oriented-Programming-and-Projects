package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: July 31, 2024
*/
/**
Exercise 02: A petrol station wishes to determine which of its products is 
preferred by its customers. Write an algorithm to read the type of fuel supplied 
(coded as follows: 1. Alcohol 2. Petrol 3. Diesel 4. End). If the user enters an 
invalid code (outside the range of 1 to 4), a new code should be requested 
(until it is valid). The program will terminate when the code entered is the number 4. 
The message "THANK YOU VERY MUCH" and the quantity of customers who filled up each 
type of fuel should be written, as in the example:

Examples:
_____________________________________
Input         Output
_____________________________________
  8         THANK YOU         
  1         Alcohol: 1         
  7         Petrol: 2        
  2         Diesel: 0        
  2              
  4       
_____________________________________
*/

import java.util.Scanner;

public class ProposedExercise_03 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int alcohol = 0;
    int petrol = 0;
    int diesel = 0;

    while (true) {
      int typeOfFuel = scanner.nextInt();
      if (typeOfFuel == 4) {
        break;
      } else if (typeOfFuel == 1) {
        alcohol += 1;
      } else if (typeOfFuel == 2) {
        petrol += 1;
      } else if (typeOfFuel == 3) {
        diesel += 1;
      } else {
        System.out.println("Type a valid code: 1. Alcohol; 2. Petrol; 3. Diesel; 4. End");
      }
    }
    System.out.println(String.format("THANK YOU\nAlcohol: %2d\nPetrol: %2d\nDiesel: %2d", alcohol, petrol, diesel));

    scanner.close();

  }

}
