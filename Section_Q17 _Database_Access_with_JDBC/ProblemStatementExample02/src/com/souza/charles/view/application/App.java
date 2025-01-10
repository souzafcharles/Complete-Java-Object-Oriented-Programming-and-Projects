package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 10, 2025
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.souza.charles.model.db.DB;
import com.souza.charles.model.db.DbException;

public class App {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("Select * from department");
			while (rs.next()) {
				System.out.printf("%d, %s%n", rs.getInt("Id"), rs.getString("Name"));
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}