package com.souza.charles.view.appliction;

import com.souza.charles.model.entities.Product;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Product, Double> stock = new HashMap<>();
        Product product01 = new Product("TV", 900.0);
        Product product02 = new Product("Notebook", 1200.0);
        Product product03 = new Product("Tablet", 400.0);
        stock.put(product01, 10000.0);
        stock.put(product02, 20000.0);
        stock.put(product03, 15000.0);
        Product product = new Product("TV", 900.0);
        System.out.println("Contains 'product' key: " + stock.containsKey(product));
    }
}