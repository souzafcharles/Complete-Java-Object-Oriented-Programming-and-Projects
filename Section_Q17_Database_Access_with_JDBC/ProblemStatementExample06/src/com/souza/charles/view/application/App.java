package com.souza.charles.view.application;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: January 11, 2025
*/

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.souza.charles.model.db.DB;
import com.souza.charles.model.db.DbException;

public class App {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = DB.getConnection();

			connection.setAutoCommit(false);

			statement = connection.createStatement();

			int rows01 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			int rows02 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

			connection.commit();

			System.out.println("rows01 = " + rows01);
			System.out.println("rows02 = " + rows02);
		} catch (SQLException e) {
			try {
				connection.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException ex) {
				throw new DbException("Error trying to rollback! Caused by: " + ex.getMessage());
			}
		} finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
}