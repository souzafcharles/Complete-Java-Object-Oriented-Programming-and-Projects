package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 06, 2024
 */
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
        System.out.printf("FINAL GRADE = %.2f\n", student.calculateFinalGrade());
        if (student.isPassed()) {
            System.out.println("PASS");
        } else {
            System.out.printf("FAILED\nMISSING %.2f POINTS\n", student.pointsMissing());
        }
        scanner.close();
    }
}
