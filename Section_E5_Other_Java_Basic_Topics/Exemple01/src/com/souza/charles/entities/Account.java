package com.souza.charles.entities;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: August 01, 2024
*/
public class Account {
	  private String holder;
	  private Double balance;
	  public Account(String holder, Double balance) {
	    this.holder = holder;
	    this.balance = balance;
	  }
	  public String getHolder() {
	    return holder;
	  }
	  public void deposit(double amount) {
	    balance += amount;
	  }
	  public void withdraw(double amount) {
	    balance -= amount;
	  }
}