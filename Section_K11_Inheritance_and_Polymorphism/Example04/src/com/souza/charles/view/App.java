package com.souza.charles.view;

import com.souza.charles.model.entities.Account;
import com.souza.charles.model.entities.BusinessAccount;
import com.souza.charles.model.entities.SavingsAccount;

public class App {

    public static void main(String[] args) {

        Account account01 = new Account(1001, "Ivaneide Benedita", 1000.00);
        account01.withdraw(200.0);
        System.out.printf("$ %.2f%n", account01.getBalance());
        Account account02 = new SavingsAccount(1002, "Guerino Crispim", 1000.00, 0.01);
        account02.withdraw(200.0);
        System.out.printf("$ %.2f%n", account02.getBalance());
        Account account03 = new BusinessAccount(1003, "Ludovico Vitalino", 1000.00, 500.0);
        account03.withdraw(200.0);
        System.out.printf("$ %.2f%n", account03.getBalance());
    }
}


