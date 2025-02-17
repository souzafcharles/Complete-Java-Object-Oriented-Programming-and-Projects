package com.souza.charles.model.dao;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: February 17, 2025
*/

import java.util.List;

import com.souza.charles.model.entities.Department;
import com.souza.charles.model.entities.Seller;

public interface SellerDao extends DAO<Seller>{

    List<Seller> findByDepartment(Department department);
}
