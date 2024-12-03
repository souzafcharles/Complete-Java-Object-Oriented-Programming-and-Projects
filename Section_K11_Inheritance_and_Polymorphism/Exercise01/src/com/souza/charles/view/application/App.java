package com.souza.charles.view.application;

import com.souza.charles.model.entities.Employee;
import com.souza.charles.model.entities.OutsoursedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println("Employee #" + (1 + i) + " data:");
            System.out.print("Outsourced (y/n)? ");
            char isOutsourced;
            isOutsourced = Character.toLowerCase(scanner.next().charAt(0));
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Hours: ");
            Integer hours = scanner.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = scanner.nextDouble();
            if (isOutsourced == 'n') {
                employees.add(new Employee(name, hours, valuePerHour));
            } else {
                System.out.print("Additional charge: ");
                Double additionalCharge = scanner.nextDouble();
                employees.add(new OutsoursedEmployee(name, hours, valuePerHour, additionalCharge));
            }
        }
        System.out.print("\nPAYMENTS:\n");
        for (Employee employee : employees) {
            System.out.print(employee);
        }
        scanner.close();
    }
}