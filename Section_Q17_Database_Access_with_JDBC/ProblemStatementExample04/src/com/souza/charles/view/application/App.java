package com.souza.charles.view.application;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: January 11, 2025
*/
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.souza.charles.model.db.DB;
import com.souza.charles.model.db.DbException;

public class App {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement(
					"UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " + "(DepartmentId = ?)");

			ps.setDouble(1, 200.0);
			ps.setInt(2, 2);

			int rowsAffected = ps.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closePreparedStatement(ps);
			DB.closeConnection();
		}

	}

}