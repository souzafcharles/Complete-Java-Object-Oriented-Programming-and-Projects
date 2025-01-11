package com.souza.charles.view.application;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: January 11, 2025
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.souza.charles.model.db.DB;
import com.souza.charles.model.db.DbIntegrityException;

public class App {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement(
					"DELETE FROM department " 
					+ "WHERE " 
					+ "(Id = ?)");

			ps.setInt(1, 5);

			int rowsAffected = ps.executeUpdate();

			System.out.println("Done! Row(s) affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closePreparedStatement(ps);
			DB.closeConnection();
		}

	}

}