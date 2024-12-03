package com.souza.charles.model.exceptions;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 03, 2024
 */

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}