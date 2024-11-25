package com.souza.charles.view;

import com.souza.charles.model.entities.BusinessAccount;

public class App {

    public static void main(String[] args) {

        BusinessAccount businessAccount = new BusinessAccount(1080, "Guerino Crispim", 0.0, 500.0);
        System.out.println(businessAccount.getNumber());
        System.out.println(businessAccount.getHolder());
        System.out.println(businessAccount.getBalance());
        System.out.println(businessAccount.getLoanLimit());
    }
}
