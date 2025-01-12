package com.souza.charles.model.dao;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 12, 2025
*/
import java.util.List;

import com.souza.charles.model.entities.Seller;

public interface SellerDao {

	void insert(Seller seller);

	void update(Seller seller);

	void deleteById(Integer id);

	Seller findById(Integer id);

	List<Seller> findAll();
}
