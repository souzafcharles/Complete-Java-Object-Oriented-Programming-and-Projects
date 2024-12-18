package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 18, 2024
 */

import com.souza.charles.model.services.PrintService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintService printService = new PrintService();
        System.out.print("How many values? ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int value = scanner.nextInt();
            printService.addValue(value);
        }
        printService.print();
        System.out.printf("\nFirst: %d", printService.first());
        scanner.close();
    }
}
