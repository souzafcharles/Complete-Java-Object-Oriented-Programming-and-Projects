package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 14, 2024
 */
import com.souza.charles.entities.Product;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Product[] arrayProduct = new Product[N];
        for (int i = 0; i < arrayProduct.length; i++) {
            scanner.nextLine();
            String name = scanner.nextLine();
            double price = scanner.nextDouble();
            arrayProduct[i] = new Product(name, price);
        }
        double averagePriceOfProductsResults = Product.averagePriceOfProducts(arrayProduct);
        System.out.printf("AVERAGE PRICE = %.2f%n", averagePriceOfProductsResults);
        scanner.close();
    }
}
