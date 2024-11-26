package com.souza.charles.view;

import com.souza.charles.model.entities.Account;
import com.souza.charles.model.entities.BusinessAccount;
import com.souza.charles.model.entities.SavingsAccount;

import java.util.ArrayList;


import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount(1001, "Ivaneide Benedita", 500.00, 0.01));
        accounts.add(new BusinessAccount(1002, "Ludovico Vitalino", 1000.00, 400.0));
        accounts.add(new SavingsAccount(1003, "Lucinda Sebastiana", 300.00, 0.01));
        accounts.add(new BusinessAccount(1002, "Guerino Crispim", 500.00, 500.0));

        double sum = 0.0;
        for (Account account : accounts) {
            sum += account.getBalance();
        }
        System.out.printf("The total balance of all accounts: $ %.2f%n", sum);

        for (Account account : accounts) {
            account.deposit(10.00);
        }

        for (Account account : accounts) {
            System.out.printf("Updated balance for account %d: $ %.2f%n", account.getNumber(), account.getBalance());
        }
    }
}