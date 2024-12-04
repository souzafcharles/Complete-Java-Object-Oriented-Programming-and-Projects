package com.souza.charles.model.exceptions;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 04, 2024
 */
public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String message) {
        super(message);
    }
}