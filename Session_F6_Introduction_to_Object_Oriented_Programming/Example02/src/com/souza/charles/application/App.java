package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 05, 2024
 */
/**
 Example Exercise Problem 01: Develop a program to read the side lengths of two triangles,
 X and Y (assuming valid measurements). Then, display the area of both triangles and indicate
 which one has the larger area. The formula to calculate the area of a triangle from the side
 lengths a, b, and c is as follows (Heron's formula):
 area = Math.sqrt(p⋅(p−a)⋅(p−b)⋅(p−c))
 where p = a + b + c / 2

 Examples:
 ______________________________________________________________________
 Input                                                    Output
 ______________________________________________________________________
 Enter the measures of triangle X:              Triangle X area: 6.0000
 3.00                                           Triangle Y area: 7.5638
 4.00                                                    Larger area: Y
 5.00
 Enter the measures of triangle Y:
 7.50
 4.50
 4.02
 ______________________________________________________________________
 */
import com.souza.charles.entities.Triangle;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle X = new Triangle();
        // Reading the measurements of triangle X
        System.out.println("Enter the measurements of triangle X:");
        X.sideA = scanner.nextDouble();
        X.sideB = scanner.nextDouble();
        X.sideC = scanner.nextDouble();
        Triangle Y = new Triangle();
        // Reading the measurements of triangle Y
        System.out.println("Enter the measurements of triangle Y:");
        Y.sideA = scanner.nextDouble();
        Y.sideB = scanner.nextDouble();
        Y.sideC = scanner.nextDouble();
        // Calculating the area of triangle X
        double perimeterX = (X.sideA + X.sideB + X.sideC) / 2.0;
        double areaX = Math.sqrt(perimeterX * (perimeterX- X.sideA) * (perimeterX - X.sideB) * (perimeterX - X.sideC));
        // Calculating the area of triangle Y
        double perimeterY = (Y.sideA + Y.sideB + Y.sideC) / 2.0;
        double areaY = Math.sqrt(perimeterY * (perimeterY - Y.sideA) * (perimeterY - Y.sideB) * (perimeterY - Y.sideC));
        // Displaying the areas of the triangles
        System.out.printf("Triangle X area: %.4f\n", areaX);
        System.out.printf("Triangle Y area: %.4f\n", areaY);
        // Determining which triangle has the larger area or if they are equal
        if (areaX > areaY) {
            System.out.println("Larger area: X");
        } else if (areaY > areaX) {
            System.out.println("Larger area: Y");
        } else {
            System.out.println("Both triangles have equal area.");
        }
        scanner.close();
    }
}