package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: November 28, 2024
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        method01();
        System.out.println("End of program!");
    }

    public static void method01() {
        System.out.println("***METHOD01 START***");
        method02();
        System.out.println("***METHOD01 END***");
    }

    public static void method02() {
        System.out.println("***METHOD02 START***");
        Scanner scanner = new Scanner(System.in);
        try {
            String[] vect = scanner.nextLine().split(" ");
            int position = scanner.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!");
            e.printStackTrace();
            scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Input error!");
        }
        scanner.close();
        System.out.println("***METHOD02 END***");
    }
}