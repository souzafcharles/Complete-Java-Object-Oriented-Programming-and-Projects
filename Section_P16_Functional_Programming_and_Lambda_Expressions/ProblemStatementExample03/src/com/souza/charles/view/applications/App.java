package com.souza.charles.view.applications;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 01, 2025
 */
import com.souza.charles.model.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("TV", 900.00));
        productList.add(new Product("Computer", 1200.00));
        productList.add(new Product("Tablet", 450.00));

        Comparator<Product> productComparator = (Product product01, Product product02) -> {
                return product01.getName().toUpperCase().compareTo(product02.getName().toUpperCase());
        };
        productList.sort(productComparator);

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}