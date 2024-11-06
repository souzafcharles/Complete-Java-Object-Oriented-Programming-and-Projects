package com.souza.charles.entities;

public class Student {

    public String name;
    public double grade01;
    public double grade02;
    public double grade03;

    public Double calculateFinalGrade() {
        return  (grade01 * 0.3) + (grade02 * 0.35) + (grade03 * 0.35);
    }

    public Boolean isPassed() {
        return calculateFinalGrade() >= 60;
    }

    public Double pointsMissing() {
        return 60 - calculateFinalGrade();
    }
}
