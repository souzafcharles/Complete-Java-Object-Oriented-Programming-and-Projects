package com.souza.charles.view.application;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 27, 2024
 */
import com.souza.charles.model.entities.Company;
import com.souza.charles.model.entities.Individual;
import com.souza.charles.model.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();
        System.out.print("Enter the number of tax payers: ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            scanner.nextLine();
            System.out.println("Tax payer #" + (1 + i) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char isIndividualOrCompany = Character.toLowerCase(scanner.next().charAt(0));
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Annual income: ");
            Double annualIncome = scanner.nextDouble();
            if (isIndividualOrCompany == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = scanner.nextDouble();
                taxPayers.add(new Individual(name, annualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = scanner.nextInt();
                taxPayers.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.print("\nTAXES PAID:\n");
        for (TaxPayer taxPayer : taxPayers) {
            System.out.println(taxPayer);
        }

        Double sum = 0.0;
        for (TaxPayer taxPayer : taxPayers) {
            sum += taxPayer.tax();
        }
        System.out.printf("\nTOTAL TAXES: %.2f%n", sum);
        scanner.close();
    }
}
