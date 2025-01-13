package com.souza.charles.view.application;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 13, 2025
*/

import com.souza.charles.model.dao.DaoFactory;
import com.souza.charles.model.dao.SellerDao;
import com.souza.charles.model.entities.Seller;

public class App {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
	
	}
}