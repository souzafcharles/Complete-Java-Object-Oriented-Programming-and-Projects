package com.souza.charles.application;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 06, 2024
 */
import com.souza.charles.entities.Employee;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Name: ");
        employee.name = scanner.nextLine();
        System.out.println("Gross Salary: ");
        employee.grossSalary = scanner.nextDouble();
        System.out.println("Tax: ");
        employee.tax = scanner.nextDouble();
        System.out.println("Employee: " + employee);
        System.out.println("Which percentage to increase salary? ");
        double percentage = scanner.nextDouble();
        employee.increaseSalary(percentage);
        System.out.println("Updated data: " + employee);
        scanner.close();
    }
}
