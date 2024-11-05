package com.souza.charles.subsection_01;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: August 22, 2024
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
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Reading the measurements of triangle X
        System.out.println("Enter the measurements of triangle X:");
        double xA = scanner.nextDouble();
        double xB = scanner.nextDouble();
        double xC = scanner.nextDouble();
        // Reading the measurements of triangle Y
        System.out.println("Enter the measurements of triangle Y:");
        double yA = scanner.nextDouble();
        double yB = scanner.nextDouble();
        double yC = scanner.nextDouble();
        // Calculating the area of triangle X
        double pX = (xA + xB + xC) / 2.0;
        double areaX = Math.sqrt(pX * (pX - xA) * (pX - xB) * (pX - xC));
        // Calculating the area of triangle Y
        double pY = (yA + yB + yC) / 2.0;
        double areaY = Math.sqrt(pY * (pY - yA) * (pY - yB) * (pY - yC));
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
