package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 06, 2024
 */
public class Student {

    public String name;
    public double grade01;
    public double grade02;
    public double grade03;

    public double calculateFinalGrade() {
        return grade01 + grade02 + grade03;
    }

    public boolean isPassed() {
        return calculateFinalGrade() >= 60.00;
    }

    public double pointsMissing() {
        if (isPassed()) {
            return 0.00;
        } else {
            return 60.00 - calculateFinalGrade();
        }
    }
}