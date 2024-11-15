package com.souza.charles;

import java.util.Scanner;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 15, 2024
 */
public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double largest = 0.0;
        int position = 0;
        System.out.print("How many numbers are you going to enter? ");
        int N = scanner.nextInt();
        double[] number = new double[N];
        for (int i = 0; i < number.length; i++) {
            System.out.print("Enter a number: ");
            number[i] = scanner.nextDouble();
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] > largest){
                largest = number[i];
                position = i;
            }
        }
        System.out.printf("LARGEST VALUE = %.2f%n", largest);
        System.out.printf("POSITION OF THE LARGEST VALUE = %d%n", position);
        scanner.close();
    }
}
