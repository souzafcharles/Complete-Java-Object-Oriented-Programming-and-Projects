package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 14, 2024
 */
import java.util.Scanner;

public class AverageHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[] people = new double[N];
        double sum = 0.0;

        for (int i = 0; i < people.length; i++) {
            people[i] = scanner.nextDouble();
            sum += people[i];
        }
        double averageHeight = sum / people.length;

        System.out.printf("AVERAGE HEIGHT = %.2f%n", averageHeight);
        scanner.close();
    }
}