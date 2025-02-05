package com.souza.charles.mongoDBSpringBoot.services.exceptions;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Project done by: Charles Fernandes de Souza
 Date: February 05, 2025
*/

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource Not Found! ID: " + id);
    }
}
