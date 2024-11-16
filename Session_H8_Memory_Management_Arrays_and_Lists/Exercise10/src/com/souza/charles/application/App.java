package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
import com.souza.charles.entities.Student;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many students will you enter? ");
        int N = scanner.nextInt();
        Student[] students = new Student[N];

        for (int i = 0; i < students.length; i++) {
            scanner.nextLine();
            System.out.println("Enter name, first and second grade of the "+(i + 1)+"º student: ");
            String name = scanner.nextLine();
            double grade01 = scanner.nextDouble();
            double grade02 = scanner.nextDouble();
            students[i] = new Student(name, grade01, grade02);
        }
        System.out.print("Approved students: ");
        String nameStudentApprovedResults = Student.showNameStudentApproved(students);
        System.out.printf("%s%n", nameStudentApprovedResults);
        scanner.close();
    }
}