package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 04, 2024
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        File file = new File("C:\\tmp\\in.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }
    }
}
