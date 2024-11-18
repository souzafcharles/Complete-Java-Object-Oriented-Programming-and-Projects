package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 18, 2024
 */
import com.souza.charles.entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("How many employees will be registered? ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            int id;
            do {
                System.out.print("Id: ");
                id = scanner.nextInt();
                if (Employee.isIdTaken(employees, id)) {
                    System.out.print("Id already taken. Try again: ");
                }
            } while (Employee.isIdTaken(employees, id));
            scanner.nextLine(); // consume the newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            Employee.addEmployee(employees, id, name, salary);
        }
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = scanner.nextInt();
        Employee employee = Employee.findEmployeeById(employees, id);
        if (employee == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = scanner.nextDouble();
            employee.increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }
        scanner.close();
    }
}