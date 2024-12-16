package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 16, 2024
 */
import com.souza.charles.model.entities.Printer;
import com.souza.charles.model.entities.Scanner;

public class App {

    public static void main(String[] args) {

        Printer p = new Printer("1080");
        p.processDoc("My Letter");
        p.print("My Letter");

        Scanner s = new Scanner("2003");
        s.processDoc("My Email");
        System.out.println("Scan result: " + s.scan());
    }
}
