package com.souza.charles.application;
/**
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example done by: Charles Fernandes de Souza
  Date: November 05, 2024
 */
import java.util.Scanner;

public class App {
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = scanner.nextDouble();
        double circumference = calculateCircumference(radius);
        double volume = calculateVolume(radius);
        System.out.printf("Circumference: %.2f%n", circumference);
        System.out.printf("Volume: %.2f%n", volume);
        System.out.printf("PI Value: %.2f%n", PI);
        scanner.close();
    }

    private static double calculateCircumference(double radius) {
        return 2 * PI * radius;
    }

    private static double calculateVolume(double radius) {
        return (4.00 / 3.00) * PI * Math.pow(radius, 3.00);
    }
}