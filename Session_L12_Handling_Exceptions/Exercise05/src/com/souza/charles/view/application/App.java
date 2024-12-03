package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 03, 2024
 */

import com.souza.charles.model.entities.Account;
import com.souza.charles.model.exceptions.DomainException;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Holder: ");
        String holder = scanner.nextLine();
        System.out.print("Initial balance: ");
        Double initialBalance = scanner.nextDouble();
        System.out.print("Withdraw limit: ");
        Double withdrawLimit = scanner.nextDouble();
        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        System.out.print("\nEnter amount for withdraw: ");
        Double amountWithdraw = scanner.nextDouble();

        try {
            account.withdraw(amountWithdraw);
            System.out.println(account);
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}