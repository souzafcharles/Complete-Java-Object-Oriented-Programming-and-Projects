package com.souza.charles.model.utils;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: January 04, 2025
*/
import com.souza.charles.model.entities.Product;
import java.util.function.Function;

public class ProductFunction implements Function<Product, String> {
    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}