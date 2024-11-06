package com.souza.charles.entities;

public class Employee {

    public String name;
    public double grossSalary;
    public double tax;

    public Double NetSalary() {
        return grossSalary - tax;
    }

    public void IncreaseSalary(double percentage) {
        grossSalary *= percentage;
    }

    @Override
    public String toString() {
        return String.format("%s, $ %.2f", name, NetSalary());
    }
}
