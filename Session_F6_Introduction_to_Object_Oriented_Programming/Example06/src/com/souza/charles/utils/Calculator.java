package com.souza.charles.utils;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example done by: Charles Fernandes de Souza
 Date: November 07, 2024
 */
public class Calculator {

    public final double PI = 3.14159;
    public double radius;

    public Double calculateCircumference(double radius){
        return 2 * PI * radius;
    }
    public Double calculateVolume(double radius){
        return (4.00/3.00) * PI * Math.pow(radius, 3.00);
    }
}