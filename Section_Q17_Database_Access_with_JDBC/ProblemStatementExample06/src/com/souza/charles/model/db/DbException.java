package com.souza.charles.model.db;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: January 11, 2025
*/

public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
}
