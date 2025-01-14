package com.souza.charles.view.application;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 14, 2025
*/

//import java.util.Date;
//import java.util.List;
import java.util.Scanner;

import com.souza.charles.model.dao.DaoFactory;
import com.souza.charles.model.dao.DepartmentDao;
//import com.souza.charles.model.dao.SellerDao;
import com.souza.charles.model.entities.Department;
//import com.souza.charles.model.entities.Seller;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);


		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("********** TEST 01: Department findByid **********");
		Department department = departmentDao.findById(1);
		System.out.println(department);

/*
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

		System.out.println("\n********** TEST 04: Seller insert **********");
		Seller newSeller = new Seller(null, "Bartholomeu Zacarias", "bartholomeu@mail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n********** TEST 05: Seller update **********");
		seller = sellerDao.findById(10);
		department = new Department(1, null);
		seller.setName("Cassandra Filisbina");
		seller.setEmail("cassandra@mail.com");
		seller.setBirthDate(new Date());
		seller.setBaseSalary(2200.00);
		seller.setDepartment(department);
		sellerDao.update(seller);
		System.out.println("Update completed!");

		System.out.println("\n********** TEST 06: Seller delete **********");
		System.out.println("Enter the Seller's Id for deleteById test: ");
		int id = scanner.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
*/
		scanner.close();
	}
}