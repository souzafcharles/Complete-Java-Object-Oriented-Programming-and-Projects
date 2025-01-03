package com.souza.charles.model.services;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: December 12, 2024
*/

public class BrazilTaxService implements TaxService{
    public double tax(double amount) {
        return amount <= 100.0 ? amount * 0.2 : amount * 0.15;
    }
}