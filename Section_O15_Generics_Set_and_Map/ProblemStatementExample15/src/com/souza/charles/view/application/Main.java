package com.souza.charles.view.application;

import com.souza.charles.model.entities.Product;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Product> set = new TreeSet<>();
        set.add(new Product("Smartphone", 910.00));
        set.add(new Product("Tablet", 550.00));
        set.add(new Product("Computer", 890.50));
        for (Product products : set) {
            System.out.println(products);
        }
    }
}