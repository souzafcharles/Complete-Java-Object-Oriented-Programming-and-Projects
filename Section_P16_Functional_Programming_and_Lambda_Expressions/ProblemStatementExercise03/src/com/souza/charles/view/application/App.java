package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: January 08, 2025
 */

import com.souza.charles.model.entities.Employee;
import com.souza.charles.model.servises.EmployeeService;
import com.souza.charles.model.utils.EmployeeFile;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter salary: ");
        Double salary = scanner.nextDouble();
        List<Employee> employees = EmployeeFile.readEmployeesFromFile(path);
        List<String> emails = EmployeeService.getEmailsOfHighSalaryEmployees(employees, salary);
        System.out.printf("Email of people whose salary is more than $%.2f: %n", salary);
        emails.forEach(System.out::println);
        double sumSalary = EmployeeService.getSumSalariesWithNamesStatingWithB(employees);
        System.out.printf("Sum of salary of people whose name starts with 'B': $%.2f%n", sumSalary);
        scanner.close();
    }
}