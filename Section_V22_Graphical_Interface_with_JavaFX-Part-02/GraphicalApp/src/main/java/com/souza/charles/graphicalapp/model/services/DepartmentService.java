package com.souza.charles.graphicalapp.model.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 19, 2025
 */

import com.souza.charles.graphicalapp.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "Computers"));
        list.add(new Department(2, "Electronics"));
        list.add(new Department(3, "Fashion"));
        list.add(new Department(4, "Books"));
        list.add(new Department(5, "Beauty"));
        list.add(new Department(6, "Shoes"));
        return list;
    }
}
