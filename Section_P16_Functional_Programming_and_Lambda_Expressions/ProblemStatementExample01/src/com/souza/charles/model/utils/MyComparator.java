package com.souza.charles.model.utils;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 01, 2025
 */

import com.souza.charles.model.entities.Product;

import java.util.Comparator;

public class MyComparator implements Comparator<Product> {
    @Override
    public int compare(Product product01, Product product02) {
        return product01.getName().toUpperCase().compareTo(product02.getName().toUpperCase());
    }
}
