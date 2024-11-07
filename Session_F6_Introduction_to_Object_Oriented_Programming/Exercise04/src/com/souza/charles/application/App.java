package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 06, 2024
 */
import com.souza.charles.utils.CurrencyConverter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the dollar price? ");
        double exchangeRate = scanner.nextDouble();
        System.out.println("How many dollars will be bought? ");
        double amountInDollars = scanner.nextDouble();
        double currencyConverterValue = CurrencyConverter.convertDollarToReal(exchangeRate, amountInDollars);
        System.out.printf("Amount to be paid in reais = %.2f%n", currencyConverterValue);
        scanner.close();
    }
}