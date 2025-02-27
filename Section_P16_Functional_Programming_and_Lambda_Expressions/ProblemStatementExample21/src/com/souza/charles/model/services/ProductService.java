package com.souza.charles.model.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 06, 2025
 */

import com.souza.charles.model.entities.Product;
import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filterSum(List<Product> productList, Predicate<Product> parameter) {
        double sum = 0.0;
        for (Product products : productList) {
            if (parameter.test(products)) {
                sum += products.getPrice();
            }
        }
        return sum;
    }
}
