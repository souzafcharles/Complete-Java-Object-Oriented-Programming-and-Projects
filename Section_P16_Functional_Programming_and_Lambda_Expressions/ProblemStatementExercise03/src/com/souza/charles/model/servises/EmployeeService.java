package com.souza.charles.model.servises;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: January 08, 2025
 */

import com.souza.charles.model.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public static List<String> getEmailsOfHighSalaryEmployees(List<Employee> employees, Double salary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > salary)
                .map(Employee::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }

    public static double getSumSalariesWithNamesStatingWithB(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getName().charAt(0) == 'B')
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
    }
}