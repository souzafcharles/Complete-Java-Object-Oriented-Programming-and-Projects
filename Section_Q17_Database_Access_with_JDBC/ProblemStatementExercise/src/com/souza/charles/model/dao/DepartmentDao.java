package com.souza.charles.model.dao;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 12, 2025
*/
import java.util.List;

import com.souza.charles.model.entities.Department;

public interface DepartmentDao {

	void insert(Department department);

	void update(Department department);

	void deleteById(Integer id);

	Department findById(Integer id);

	List<Department> findAll();

}
