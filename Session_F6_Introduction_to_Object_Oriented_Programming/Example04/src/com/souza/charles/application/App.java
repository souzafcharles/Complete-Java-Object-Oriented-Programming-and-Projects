package com.souza.charles.application;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 05, 2024
 */
/**
 * Example Exercise Problem 02: Write a program to read the data of a product in stock (name, price and quantity in stock).
 * Then:
 * • Display the product data (name, price, quantity in stock, total value in stock)
 * • Perform a stock entry and display the product data again
 * • Perform a stock exit and display the product data again
 * To solve this problem, you should create a CLASS according to the project alongside:
 * <p>
 * Product
 * ____________________________________
 * Name: string
 * Price: double
 * Quantity: int
 * ____________________________________
 * TotalValueInStock(): double
 * AddProducts(quantity: int): void
 * RemoveProducts(quantity: int): void
 * <p>
 * Examples:
 * __________________________________________________________________________________________
 * Input                                                    Output
 * __________________________________________________________________________________________
 * Enter product data:                 Product data: TV, $ 900.00, 10 units, Total: $ 900.00
 * Name: TV                            Update data: TV, $ 900.00, 15 units, Total: $ 13500.00
 * Price: 900.00                       Update data: TV, $ 900.00, 12 units, Total: $ 10800.00
 * Quantity in stock: 10
 * <p>
 * Enter the number of products
 * to be added in stock: 5
 * <p>
 * Enter the number of products
 * to be removed from stock: 3
 * __________________________________________________________________________________________
 */

import com.souza.charles.entities.Product;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        product.name = scanner.nextLine();
        System.out.println("Price: ");
        product.price = scanner.nextDouble();
        System.out.println("Quantity: ");
        product.quantity = scanner.nextInt();
        System.out.println("Product data:" + product);
        System.out.println("Enter the number of products to be added in stock: ");
        int quantity = scanner.nextInt();
        product.addProducts(quantity);
        System.out.println("Update data:" + product);
        System.out.println("Enter the number of products to be removed from stock: ");
        quantity = scanner.nextInt();
        product.removeProducts(quantity);
        System.out.println("Update data:" + product);
        scanner.close();
    }
}