package com.souza.charles.application;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 05, 2024
 */
/**
 Exercise 01: Write a program to read the values of the width and height of a rectangle.
 Then, display on the screen the value of its area, perimeter, and diagonal.
 Use a class as shown in the project below.

 Rectangle
 _____________________
 - Width: double
 - Height: double
 _____________________
 + Area(): double
 + Perimeter(): double
 + Diagonal(): double

 Examples:
 __________________________________________________________
 Input                                               Output
 __________________________________________________________
 Enter rectangle width and height:             AREA = 12.00
 3.00                                     PERIMETER = 14.00
 4.00                                       DIAGONAL = 5.00
 __________________________________________________________
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
