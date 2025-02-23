package com.souza.charles.graphicalapp.model.dao;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 23, 2025
 */

import com.souza.charles.graphicalapp.model.entities.Department;
import com.souza.charles.graphicalapp.model.entities.Seller;

import java.util.List;

public interface SellerDao extends DAO<Seller> {

    List<Seller> findByDepartment(Department department);
}