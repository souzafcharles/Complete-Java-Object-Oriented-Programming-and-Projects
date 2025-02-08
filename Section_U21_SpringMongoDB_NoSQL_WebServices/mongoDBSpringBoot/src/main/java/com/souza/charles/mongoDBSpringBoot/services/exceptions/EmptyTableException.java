package com.souza.charles.mongoDBSpringBoot.services.exceptions;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 08, 2025
 */


public class EmptyTableException extends RuntimeException {
    public EmptyTableException() {
        super("The requested table is empty or does not exist.");
    }
}