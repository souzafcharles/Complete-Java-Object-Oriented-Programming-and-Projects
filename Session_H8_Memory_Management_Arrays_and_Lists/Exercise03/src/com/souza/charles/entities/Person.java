package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 15, 2024
 */


public class Person {
    private String name;
    private int age;
    private double height;

    public Person() {
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static double calculateAverageHeight(Person[] persons) {
        double sum = 0;
        for (int i = 0; i < persons.length; i++) {
            sum += persons[i].getHeight();
        }
        return sum / persons.length;
    }

    public static double countPeopleUnder16YearsOld(Person[] persons) {
        int countUnder16YearsOld = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() < 16) {
                countUnder16YearsOld++;
            }
        }
        return (countUnder16YearsOld * 100.0) / persons.length;
    }

    public static String namePeopleUnder16YearsOld(Person[] persons) {
        StringBuilder namesUnder16 = new StringBuilder();
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() < 16) {
                if (namesUnder16.length() > 0) {
                    namesUnder16.append("\n");
                }
                namesUnder16.append(persons[i].getName());
            }
        }
        return namesUnder16.toString();
    }
}