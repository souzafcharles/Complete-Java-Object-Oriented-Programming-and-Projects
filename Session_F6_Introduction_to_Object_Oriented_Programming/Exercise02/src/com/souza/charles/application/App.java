package com.souza.charles.application;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 06, 2024
 */
/**
 Exercise 02: Write a program to read an employee's data
 (name, gross salary, and tax). Then, display the employee's data
 (name and net salary). Next, increase the employee's salary based
 on a given percentage (only the gross salary is affected by the percentage)
 and display the employee's data again. Use the designed class below:

 __________________________________________
 Employee
 __________________________________________
 - Name: String
 - GrossSalary: double
 - Tax: double
 __________________________________________
 + NetSalary(): double
 + IncreaseSalary(percentage: double): void
 __________________________________________


 Examples:
 _______________________________________________________________
 Input                      |Output
 ___________________________|___________________________________
 Name: Joao Silva           |Employee: Joao Silva, $ 5000.00
 Gross salary: 6000.00      |Updated data: Joao Silva, $ 5600.00
 Tax: 1000.00               |
 Which percentage to        |
 increase salary? 10.0      |
 ___________________________|___________________________________
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
        scanner.close();
    }
}
