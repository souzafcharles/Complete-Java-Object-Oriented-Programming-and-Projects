package com.souza.charles.graphicalapp.model.db;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: February 17, 2025
*/

import java.io.Serial;

public class DbException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DbException(String message) {
        super(message);
    }
}