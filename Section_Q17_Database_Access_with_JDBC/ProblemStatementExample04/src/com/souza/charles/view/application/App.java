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
import com.souza.charles.model.db.DbException;

public class App {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " + "(DepartmentId = ?)");

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closePreparedStatement(preparedStatement);
            DB.closeConnection();
        }

    }

}