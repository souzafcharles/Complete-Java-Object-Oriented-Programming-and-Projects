package com.souza.charles.model.db;
/*
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: January 12, 2025
*/
public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbIntegrityException(String msg) {
		super(msg);
	}
}
