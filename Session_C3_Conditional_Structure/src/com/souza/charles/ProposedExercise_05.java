package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 22, 2024
*/
/**
Exercise 05: Based on the table below, compose a program that reads 
the code of an item and its quantity. Subsequently, compute and 
display the amount payable. 
_________________________________
CODE      SPECIFICATION     PRICE
_________________________________
1          Hot dog          $4.00
2          X-Salad          $4.50
3          X-Bacon          $5.00
4          Plain Toast      $2.00
5          Soda             $1.50
_________________________________
*/
import java.util.Scanner;

public class ProposedExercise_05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double amountPayable;
		int itemCode = scanner.nextInt();
		int itemQuantity = scanner.nextInt();
		if (itemCode == 1) {
			amountPayable = itemQuantity * 4.00;
		} else if (itemCode == 2) {
			amountPayable = itemQuantity * 4.50;
		} else if (itemCode == 3) {
			amountPayable = itemQuantity * 5.00;
		} else if (itemCode == 4) {
			amountPayable = itemQuantity * 2.00;
		} else {
			amountPayable = itemQuantity * 1.50;
		}
		System.out.printf("The amount payable is $ %.2f", amountPayable);
		scanner.close();
	}
	
}