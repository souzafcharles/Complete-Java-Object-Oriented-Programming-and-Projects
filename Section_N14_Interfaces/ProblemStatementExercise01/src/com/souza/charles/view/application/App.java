package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 13, 2024
 */

import com.souza.charles.model.entities.Contract;
import com.souza.charles.model.entities.Installment;
import com.souza.charles.model.services.ContractService;
import com.souza.charles.model.services.PaypalService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Input the contract details:");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print(" Date (dd/MM/yyyy): ");
        LocalDate dateTime = LocalDate.parse(scanner.next(), dateTimeFormatter);
        System.out.print("Contract value: ");
        double contractValue = scanner.nextDouble();
        Contract contract = new Contract(number, dateTime, contractValue);
        System.out.print("Enter the number of instalments: ");
        int numberOfInstalments = scanner.nextInt();
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, numberOfInstalments);
        System.out.println("Installment: ");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
        scanner.close();
    }
}