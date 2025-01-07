package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: January 07, 2025
 */

import com.souza.charles.model.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        System.out.print("Enter full file path: ");
        String path = scanner.nextLine();
        try {
            ;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String productFile = bufferedReader.readLine();
            while (productFile != null) {
                String[] field = productFile.split(",");
                productList.add(new Product(field[0], Double.parseDouble(field[1])));
                productFile = bufferedReader.readLine();
            }
            double average = productList.stream()
                    .map(Product::getPrice)
                    .reduce(0.0, Double::sum) / productList.size();
            System.out.printf("Average price: $%.2f%n", average);

            Comparator<String> comparator = (string01, string02) -> string01.toUpperCase().compareTo(string02.toUpperCase());
            List<String> productNames = productList.stream()
                    .filter(product -> product.getPrice() < average)
                    .map(Product::getName)
                    .sorted(comparator.reversed())
                    .toList();
            productNames.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            ;
        }
    }
}