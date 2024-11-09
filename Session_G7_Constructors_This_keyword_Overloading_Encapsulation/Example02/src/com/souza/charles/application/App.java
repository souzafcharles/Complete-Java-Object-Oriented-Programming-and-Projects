package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 08, 2024
 */
import com.souza.charles.entities.Product;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Price: ");
        double price = scanner.nextDouble();
        Product product = new Product(name, price);
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
