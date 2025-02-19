package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 09, 2024
 */

import com.souza.charles.entities.Account;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter account holder: ");
        String holder = scanner.nextLine();
        System.out.print("Is there an initial deposit (y/n)? ");
        String response = scanner.nextLine().trim().toLowerCase();
        boolean hasInitialDeposit = response.equals("y");
        Account account;
        
     if (hasInitialDeposit) {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = scanner.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder, null);
        }
     
        System.out.println("\nAccount data:");
        System.out.println(account);
        System.out.print("\nEnter a deposit value: ");
        double depositValue = scanner.nextDouble();
        account.deposit(depositValue);
        System.out.println("Updated account data:");
        System.out.println(account);
        System.out.print("\nEnter a withdraw value: ");
        double withdrawValue = scanner.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("Updated account data:");
        System.out.println(account);
        scanner.close();
    }
}
