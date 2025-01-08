package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: January 07, 2025
 */

import com.souza.charles.model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter full file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter salary: ");
        Double salary = scanner.nextDouble();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] field = line.split(",");
                employees.add(new Employee(field[0], field[1], Double.parseDouble(field[2])));
                line = bufferedReader.readLine();
            }
            List<String> emailList = employees.stream()
                    .filter(employee -> employee.getSalary() > salary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();
            System.out.printf("Email of people whose salary is more than $%.2f: %n", salary);
            emailList.forEach(System.out::println);
            double sumSalary = employees.stream()
                    .filter(employee -> employee.getName().charAt(0) == 'B')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);
            System.out.printf("Sum of salary of people whose name starts with 'B': $%.2f%n", sumSalary);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}