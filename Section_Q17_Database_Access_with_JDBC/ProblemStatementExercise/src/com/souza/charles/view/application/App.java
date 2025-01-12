package com.souza.charles.view.application;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 12, 2025
*/

import java.util.Date;

import com.souza.charles.model.dao.DaoFactory;
import com.souza.charles.model.dao.SellerDao;
import com.souza.charles.model.entities.Seller;

public class App {

	public static void main(String[] args) {

		Seller seller = new Seller(10, "Filomena Justina", "filomanana@email.com", new Date(), 4000.00);
		System.out.println(seller);

		SellerDao sellerDao = DaoFactory.createSellerDao();
	}
}