package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 06, 2024
 */
/**
 Exercise 03: Create a program to read the name of a student and the three grades
 they obtained in the three trimesters of the year (the first trimester is worth 30
 and the second and third are worth 35 each). In the end, show the student's final
 grade for the year. Also say whether the student is approved (PASS) or not (FAILED) and,
 if negative, how many points are missing for the student to obtain the minimum to be
 approved (which is 60% of the grade). You must create a Student class to solve this problem.

 _______________________________
 Student
 _______________________________
 - Name: String
 - Grade01: double
 - Grade02: double
 - Grade03: double
 _______________________________
 + CalculateFinalGrade(): double
 + isPassed(): boolean
 + pointsMissing(): double
 _______________________________


 Examples:
 _____________________________________

 Input            |Output
 _________________|___________________
 Alex Green       |FINAL GRADE = 90.00
 27.00            |PASS
 31.00            |
 32.00            |
 _____________________________________
 Alex Green       |FINAL GRADE = 52.00
 17.00            |FAILED
 20.00            |MISSING 8.00 POINTS
 15.00            |
 _____________________________________
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