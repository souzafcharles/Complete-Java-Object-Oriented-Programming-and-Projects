package com.souza.charles.view;

import com.souza.charles.model.entities.Account;
import com.souza.charles.model.entities.BusinessAccount;
import com.souza.charles.model.entities.SavingsAccount;

public class App {

    public static void main(String[] args) {

        Account account = new Account(1001, "Ivaneide Benedita", 0.0);
        BusinessAccount businessAccount = new BusinessAccount(1002, "Guerino Crispim", 0.0, 500.0);


        // UPCASTING

        Account account01 = businessAccount;
        Account account02 = new BusinessAccount(1003, "Epaminondas Astolpho", 0.0, 200.0);
        Account account03 = new SavingsAccount(1004, "Sibila Sebastiana", 0.0, 0.01);


        // DOWNCASTING

        BusinessAccount account04 = (BusinessAccount)account02;
        account04.loan(100.0);

        // BusinessAccount account05 = (BusinessAccount)account03;
        if (account03 instanceof BusinessAccount) {
            BusinessAccount account05 = (BusinessAccount) account03;
            account05.loan(200.0);
            System.out.println("Loan!");
        }

        if (account03 instanceof SavingsAccount){
            SavingsAccount account05 = (SavingsAccount)account03;
            account05.getBalance();
            System.out.println("Update!");
        }
    }
}
