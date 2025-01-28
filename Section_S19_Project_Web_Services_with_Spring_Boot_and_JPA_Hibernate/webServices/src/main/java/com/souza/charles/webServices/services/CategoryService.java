package com.souza.charles.webServices.services;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Project done by: Charles Fernandes de Souza
 Date: January 28, 2025
*/

import com.souza.charles.webServices.entities.Category;
import com.souza.charles.webServices.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        Optional<Category> categoryFindById = categoryRepository.findById(id);
        return categoryFindById.get();
    }
}
