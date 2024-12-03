package com.souza.charles.utils;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 06, 2024
 */
public class CurrencyConverter {
    public static final double IOF_RATE = 0.06;
    public static double convertDollarToReal(double exchangeRate, double amountInDollars) {
        return exchangeRate * amountInDollars * (1 + IOF_RATE);
    }
}
