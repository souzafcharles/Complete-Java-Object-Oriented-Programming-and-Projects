package com.souza.charles.model.dao;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: February 17, 2025
*/

import com.souza.charles.model.dao.impl.DepartmentDaoJDBC;
import com.souza.charles.model.dao.impl.SellerDaoJDBC;

import com.souza.charles.model.db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}