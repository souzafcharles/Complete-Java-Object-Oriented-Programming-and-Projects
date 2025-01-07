package com.souza.charles.view.application;

import com.souza.charles.model.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        System.out.print("Enter full file path: ");
        String path = scanner.nextLine();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] field = line.split(",");
                list.add(new Product(field[0], Double.parseDouble(field[1])));
                line = bufferedReader.readLine();
            }
            double average = list.stream()
                    .mapToDouble(Product::getPrice)
                    .reduce(0.0, Double::sum) / list.size();
            System.out.printf("Average price: $%.2f%n", average);

            Comparator<String> comparator = (x, y) -> x.toUpperCase().compareTo(y.toUpperCase());
            List<String> productNames = list.stream()
                    .filter(product -> product.getPrice() < average)
                    .map(Product::getName)
                    .sorted(comparator.reversed())
                    .toList();
            productNames.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}