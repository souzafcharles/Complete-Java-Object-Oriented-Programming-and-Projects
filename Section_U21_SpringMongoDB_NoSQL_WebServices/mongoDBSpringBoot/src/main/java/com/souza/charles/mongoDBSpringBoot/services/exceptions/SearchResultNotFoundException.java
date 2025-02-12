package com.souza.charles.mongoDBSpringBoot.services.exceptions;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 08, 2025
 */

public class SearchResultNotFoundException extends RuntimeException {
    public SearchResultNotFoundException(Object text) {
        super("No results found for the search: " + text);
    }
}