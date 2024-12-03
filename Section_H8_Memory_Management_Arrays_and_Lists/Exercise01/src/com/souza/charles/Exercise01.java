package com.souza.charles;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 15, 2024
 */
import java.util.Scanner;

public class Exercise01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers are you going to enter? ");
        int N = scanner.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter a number: ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("NEGATIVE NUMBERS: ");
        for (int number : numbers) {
            if (number < 0) {
                System.out.printf("%d%n", number);
            }
        }
        scanner.close();
    }
}
