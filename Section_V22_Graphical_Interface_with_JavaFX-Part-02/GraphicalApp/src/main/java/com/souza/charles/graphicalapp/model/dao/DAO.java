package com.souza.charles.graphicalapp.model.dao;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 23, 2025
 */

import java.util.List;

public interface DAO<T> {
    void insert(T object);

    void update(T object);

    void deleteById(Integer id);

    T findById(Integer id);

    List<T> findAll();
}