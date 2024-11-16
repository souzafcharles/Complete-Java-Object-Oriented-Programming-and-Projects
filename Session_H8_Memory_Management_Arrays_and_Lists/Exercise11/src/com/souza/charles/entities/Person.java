package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
public class Person {
    private double height;
    private char gender;

    public Person() {
    }

    public Person(double height, char gender) {
        this.height = height;
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static double calculateShortestHeight(Person[] person) {
        double shortestHeight = person[0].getHeight();
        for (int i = 1; i < person.length; i++) {
            if (person[i].getHeight() < shortestHeight) {
                shortestHeight = person[i].getHeight();
            }
        }
        return shortestHeight;
    }

    public static double calculateTallestHeight(Person[] person) {
        double tallestHeight = person[0].getHeight();
        for (int i = 1; i < person.length; i++) {
            if (person[i].getHeight() > tallestHeight) {
                tallestHeight = person[i].getHeight();
            }
        }
        return tallestHeight;
    }

    public static double calculateAverageHeightOfWomen(Person[] person) {
        double sum = 0.0;
        int countofWomen = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i].getGender() == 'F') {
                sum += person[i].getHeight();
                countofWomen++;
            }
        }
        return countofWomen == 0 ? 0.0 : sum / countofWomen;
    }

    public static int calculateNumberOfMen(Person[] person) {
        int countOfMen = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i].getGender() == 'M') {
                countOfMen++;
            }
        }
        return countOfMen;
    }
}