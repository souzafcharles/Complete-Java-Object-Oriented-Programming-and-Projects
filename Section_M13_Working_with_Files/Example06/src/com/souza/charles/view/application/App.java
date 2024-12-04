package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 04, 2024
 */
import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a folder path: ");
        String strPath = scanner.nextLine();
        File path = new File(strPath);
        System.out.println("getPath: " + path.getPath());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getName: " + path.getName());
        scanner.close();
    }
}