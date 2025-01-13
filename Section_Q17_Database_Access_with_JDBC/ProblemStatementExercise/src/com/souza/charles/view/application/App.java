package com.souza.charles.view.application;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 13, 2025
*/

import java.util.List;

import com.souza.charles.model.dao.DaoFactory;
import com.souza.charles.model.dao.SellerDao;
import com.souza.charles.model.entities.Department;
import com.souza.charles.model.entities.Seller;

public class App {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("********** TEST 01: Seller findByid **********");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n********** TEST 02: Seller findByDepartment **********");
		Department department = new Department(3, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		for (Seller s : listSeller) {
			System.out.println(s);
		}

		System.out.println("\n********** TEST 03: Seller findAll **********");
		listSeller = sellerDao.findAll();
		for (Seller s : listSeller) {
			System.out.println(s);
		}
	}
}