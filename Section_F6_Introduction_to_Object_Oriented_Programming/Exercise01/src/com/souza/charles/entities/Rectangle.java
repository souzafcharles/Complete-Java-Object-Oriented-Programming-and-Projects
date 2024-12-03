package com.souza.charles.entities;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 05, 2024
 */
public class Rectangle {

    public double width, height;

    public Double calculateArea() {
        return width * height;
    }

    public Double calculatePerimeter() {
        return 2 * (width + height);
    }

    public Double calculateDiagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
