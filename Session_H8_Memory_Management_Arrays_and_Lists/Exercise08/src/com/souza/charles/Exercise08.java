package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEven = 0;
        double sum = 0.0, evenArithmeticAverage;
        System.out.print("How many elements will the array have? ");
        int N = scanner.nextInt();
        int[] evenNumber = new int[N];
        for (int i = 0; i < evenNumber.length; i++) {
            System.out.print("Enter a number: ");
            evenNumber[i] = scanner.nextInt();
        }
        for (int i = 0; i < evenNumber.length; i++) {
            if (evenNumber[i] % 2 == 0) {
                sum += evenNumber[i];
                countEven++;
            }
        }
        if (countEven > 0) {
            evenArithmeticAverage = sum / countEven++;
            System.out.printf("EVEN NUMBERS AVERAGE = %.1f%n", evenArithmeticAverage);
        }else {
            System.out.println("NO EVEN NUMBER");
        }
        scanner.close();
    }
}