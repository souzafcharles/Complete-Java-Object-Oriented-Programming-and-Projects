package com.souza.charles.view.applications;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 06, 2025
 */
import com.souza.charles.model.entities.Product;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("TV", 900.00));
        productList.add(new Product("Mouse", 50.00));
        productList.add(new Product("Tablet", 450.00));
        productList.add(new Product("HD Case", 80.90));
        productList.forEach(System.out::println);
    }
}