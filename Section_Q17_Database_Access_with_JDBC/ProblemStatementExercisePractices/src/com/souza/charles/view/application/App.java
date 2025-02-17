package com.souza.charles.view.application;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: February 17, 2025
*/

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.souza.charles.model.dao.DaoFactory;
import com.souza.charles.model.dao.DepartmentDao;
import com.souza.charles.model.dao.SellerDao;
import com.souza.charles.model.entities.Department;
import com.souza.charles.model.entities.Seller;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("********** TEST 01: Seller findById **********");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("********** TEST 01: Department findById **********");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n********** TEST 02: Seller findByDepartment **********");
        department = new Department(3, null);
        List<Seller> listSeller = sellerDao.findByDepartment(department);
        for (Seller s : listSeller) {
            System.out.println(s);
        }

        System.out.println("\n********** TEST 03: Seller findAll **********");
        listSeller = sellerDao.findAll();
        for (Seller s : listSeller) {
            System.out.println(s);
        }

        System.out.println("\n********** TEST 03: Department findAll **********");
        List<Department> listDepartment = departmentDao.findAll();
        for (Department d : listDepartment) {
            System.out.println(d);
        }

        System.out.println("\n********** TEST 04: Seller insert **********");
        Seller newSeller = new Seller(null, "Bartholomeu Zacarias", "bartholomeu@mail.com", LocalDate.now(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Seller id = " + newSeller.getId());

        System.out.println("\n********** TEST 04: Department insert **********");
        Department newDepartment = new Department(null, "Toys");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Department Name = " + newDepartment.getName());

        System.out.println("\n********** TEST 05: Seller update **********");
        seller = sellerDao.findById(10);
        if (seller != null) {
            department = new Department(1, null);
            seller.setName("Cassandra Filisbina");
            seller.setEmail("cassandra@mail.com");
            seller.setBirthDate(LocalDate.now());
            seller.setBaseSalary(2200.00);
            seller.setDepartment(department);
            sellerDao.update(seller);
            System.out.println("Update completed!");
        } else {
            System.out.println("Seller not found with Id 10.");
        }

        System.out.println("\n********** TEST 05: Department update **********");
        department = departmentDao.findById(7);
        if (department != null) {
            department.setName("Gifts");
            departmentDao.update(department);
            System.out.println("Update completed!");
        } else {
            System.out.println("Department not found with Id 7.");
        }

        System.out.println("\n********** TEST 06: Seller delete **********");
        System.out.print("Enter the Seller Id for deleteById test: ");
        int id = scanner.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.println("\n********** TEST 06: Department delete **********");
        System.out.print("Enter the Department Id for deleteById test: ");
        id = scanner.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        scanner.close();
    }
}