package com.souza.charles.application;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 05, 2024
 */
import com.souza.charles.entities.Rectangle;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();
        rectangle.width = scanner.nextDouble();
        rectangle.height= scanner.nextDouble();
        System.out.printf("AREA = %.2f%n", rectangle.calculateArea());
        System.out.printf("PERIMETER = %.2f%n", rectangle.calculatePerimeter());
        System.out.printf("DIAGONAL = %.2f%n", rectangle.calculateDiagonal());
        scanner.close();
    }
}
