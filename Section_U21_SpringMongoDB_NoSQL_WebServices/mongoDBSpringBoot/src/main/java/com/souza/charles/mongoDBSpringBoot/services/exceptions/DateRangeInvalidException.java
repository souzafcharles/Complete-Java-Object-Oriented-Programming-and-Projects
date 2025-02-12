package com.souza.charles.mongoDBSpringBoot.services.exceptions;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Project done by: Charles Fernandes de Souza
 Date: February 12, 2025
*/

public class DateRangeInvalidException extends RuntimeException {
    public DateRangeInvalidException() {
        super("Invalid date range provided. Please ensure the minimum date is no later than the maximum and current dates.");
    }
}