package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 07, 2024
 */
import com.souza.charles.utils.Calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double radius = scanner.nextDouble();
        double circumference = calculator.calculateCircumference(radius);
        double volume = calculator.calculateVolume(radius);
        System.out.printf("Circumference: %.2f%n", circumference);
        System.out.printf("Volume: %.2f%n", volume);
        System.out.printf("PI Value: %.2f%n", calculator.PI);
        scanner.close();
    }
}