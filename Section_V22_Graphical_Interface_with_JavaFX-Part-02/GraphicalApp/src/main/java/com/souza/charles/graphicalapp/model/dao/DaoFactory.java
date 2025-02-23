package com.souza.charles.graphicalapp.model.dao;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 23, 2025
 */

import com.souza.charles.graphicalapp.model.dao.impl.DepartmentDaoJDBC;
import com.souza.charles.graphicalapp.model.dao.impl.SellerDaoJDBC;
import com.souza.charles.graphicalapp.model.db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}