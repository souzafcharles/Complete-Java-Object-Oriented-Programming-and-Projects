package com.souza.charles.webServices.services;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Project done by: Charles Fernandes de Souza
 Date: January 23, 2025
*/
import com.souza.charles.webServices.entities.Product;
import com.souza.charles.webServices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping
    public Product findById(Long id) {
        Optional<Product> productFindById = productRepository.findById(id);
        return productFindById.get();
    }
}
