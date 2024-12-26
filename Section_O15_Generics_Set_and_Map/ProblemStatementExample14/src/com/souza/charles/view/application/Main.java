package com.souza.charles.view.application;

import com.souza.charles.model.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> set = new HashSet<>();
        set.add(new Product("Computer", 890.50));
        set.add(new Product("Smartphone", 910.00));
        set.add(new Product("Tablet", 550.00));
        Product product = new Product("Smartphone", 910.00);
        System.out.println(set.contains(product));
        for (Product products : set) {
            System.out.println(products);
        }
    }
}