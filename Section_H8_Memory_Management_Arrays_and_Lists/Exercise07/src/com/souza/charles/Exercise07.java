package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0, arithmeticAverage;
        System.out.print("How many elements will the array have? ");
        int N = scanner.nextInt();
        double[] realNumber = new double[N];
        for (int i = 0; i < realNumber.length; i++) {
            System.out.print("Enter a number: ");
            realNumber[i] = scanner.nextDouble();
        }
        for (int i = 0; i < realNumber.length; i++) {
            sum += realNumber[i];
        }
        arithmeticAverage = sum / realNumber.length;
        System.out.printf("ARRAY AVERAGE  = %.3f", arithmeticAverage);
        System.out.println("\nELEMENTS BELOW THE AVERAGE:");
        for (int i = 0; i < realNumber.length; i++) {
            if (realNumber[i] < arithmeticAverage) {
                System.out.printf("%.1f%n ", realNumber[i]);
            }
        }
        scanner.close();
    }
}