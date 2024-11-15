package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 15, 2024
 */
import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0, average;
        System.out.println("How many numbers are you going to enter? ");
        int N = scanner.nextInt();
        double[] realNumbers = new double[N];
        for (int i = 0; i < realNumbers.length; i++) {
            System.out.print("Enter a number: ");
            realNumbers[i] = scanner.nextDouble();
        }
        System.out.print("VALUES = ");
        for (int i = 0; i < realNumbers.length; i++) {
            System.out.printf("%.1f ", realNumbers[i]);
        }
        for (int i = 0; i < realNumbers.length; i++) {
            sum += realNumbers[i];
        }
        System.out.printf("\nSUM = %.2f\n", sum);
        System.out.printf("AVERAGE = %.2f ", average = (sum / realNumbers.length));
    }
}