package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date:  November 17, 2024
 */
import com.souza.charles.entities.Product;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product("TV", 900.00, 1);
        System.out.println(product);
        scanner.close();
    }
}