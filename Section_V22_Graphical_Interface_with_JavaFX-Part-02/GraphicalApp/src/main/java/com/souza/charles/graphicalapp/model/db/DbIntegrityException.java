package com.souza.charles.graphicalapp.model.db;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 23, 2025
 */

import java.io.Serial;

public class DbIntegrityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String message) {
        super(message);
    }
}