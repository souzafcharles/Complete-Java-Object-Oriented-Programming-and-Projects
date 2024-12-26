package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 25, 2024
 */

import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("Computer");
        set.add("Smartphone");
        set.add("Tablet");

        for (String print : set) {
            System.out.println(print);
        }

        System.out.println(set.contains("Notebook"));
        System.out.println(set.contains("Smartphone"));
    }
}