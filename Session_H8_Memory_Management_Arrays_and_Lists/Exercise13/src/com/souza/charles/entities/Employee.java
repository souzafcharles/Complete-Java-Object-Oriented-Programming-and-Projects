package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 18, 2024
 */
import java.util.List;
import java.util.Objects;

public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        salary += (salary * percentage) / 100.0;
    }

    public static boolean isIdTaken(List<Employee> employees, int id) {
        return employees.stream().anyMatch(employee -> employee.getId().equals(id));
    }

    public static void addEmployee(List<Employee> employees, int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
    }

    public static Employee findEmployeeById(List<Employee> employees, int id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f", id, name, salary);
    }
}