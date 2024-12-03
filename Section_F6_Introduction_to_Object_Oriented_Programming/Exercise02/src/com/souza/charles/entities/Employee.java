package com.souza.charles.entities;

public class Employee {

    public String name;
    public double grossSalary;
    public double tax;

    public Double netSalary() {
        return grossSalary - tax;
    }

    public void increaseSalary(double percentage) {
        grossSalary += grossSalary * percentage / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s, $ %.2f", name, netSalary());
    }
}
