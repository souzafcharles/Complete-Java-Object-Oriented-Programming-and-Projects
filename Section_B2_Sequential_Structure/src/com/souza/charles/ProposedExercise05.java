package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 05: Write a program to read the code of item 1, 
the quantity of item 1, the unit value of each item 1, 
the code of item 2, the quantity of item 2, and the unit value of each item 2. 
Calculate and display the total amount to be paid.
*/
import java.util.Scanner;

public class ProposedExercise05 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalAmount = 0.0;
        for (int i = 0; i < 2; i++) {
            int componentCode = scanner.nextInt();
            int componentQuantity = scanner.nextInt();
            double unitPrice = scanner.nextDouble();
            double componentCost = componentQuantity * unitPrice;
            totalAmount += componentCost;
        }
        System.out.printf("TOTAL AMOUNT: £ %.2f%n", totalAmount);
        scanner.close();
    }
}
