package com.souza.charles.graphicalapp.model.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 19, 2025
 */

import com.souza.charles.graphicalapp.model.dao.DaoFactory;
import com.souza.charles.graphicalapp.model.dao.DepartmentDao;
import com.souza.charles.graphicalapp.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}