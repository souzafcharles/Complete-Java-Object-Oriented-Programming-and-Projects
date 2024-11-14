package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 14, 2024
 */
public class Product {

    private String name;
    private Double price;

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static double averagePriceOfProducts(Product[] products) {
        double sum = 0;
        for (int i = 0; i < products.length; i++) {
            sum += products[i].getPrice();
        }
        return sum / products.length;
    }
}
