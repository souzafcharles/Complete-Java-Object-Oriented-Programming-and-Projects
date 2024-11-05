package com.souza.charles.entities;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 05, 2024
 */
public class Triangle {
    public double sideA, sideB, sideC;

    public Double calculateAreaTriangle (){
        double  perimeter = (sideA + sideB + sideC) / 2.0;
        return  Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
    }
}
