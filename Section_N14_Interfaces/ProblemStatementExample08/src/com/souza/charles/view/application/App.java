package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 16, 2024
 */

import com.souza.charles.model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        String path = "C:\\tmp\\in.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String employeesFile = bufferedReader.readLine();
            while (employeesFile != null) {
                String[] fields = employeesFile.split(",");
                employees.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeesFile = bufferedReader.readLine();
            }
            Collections.sort(employees);
            for (Employee employee : employees) {
                System.out.printf("%s, %.2f%n", employee.getName(), employee.getSalary());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}