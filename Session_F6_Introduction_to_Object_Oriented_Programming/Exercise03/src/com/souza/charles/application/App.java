package com.souza.charles.application;

import com.souza.charles.entities.Student;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        student.name = scanner.nextLine();
        student.grade01 = scanner.nextDouble();
        student.grade02 = scanner.nextDouble();
        student.grade03 = scanner.nextDouble();
        double finalGrade = student.calculateFinalGrade();
        System.out.println("FINAL GRADE: " + finalGrade);
        if (student.isPassed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
            System.out.println("MISSING: " + student.pointsMissing());
        }
        scanner.close();
    }
}
