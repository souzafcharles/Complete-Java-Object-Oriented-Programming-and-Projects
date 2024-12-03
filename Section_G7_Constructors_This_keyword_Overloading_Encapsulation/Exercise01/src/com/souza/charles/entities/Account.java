package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 09, 2024
 */
public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    public final Double WITHDRAW_RATE = 5.00;

    public Account() {
    }

    public Account(Integer number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Account(Integer number, String holder, Double initialDeposit) {
        this.number = number;
        this.holder = holder;
        this.balance = (initialDeposit != null) ? initialDeposit : 0.0;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= (amount + (1 * WITHDRAW_RATE));
        }
    }

    @Override
    public String toString() {
        return String.format("Account %d, Holder: %s, Balance: $ %.2f%n", number, holder, balance);
    }
}
