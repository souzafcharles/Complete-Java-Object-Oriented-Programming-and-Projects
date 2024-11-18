package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date:  November 17, 2024
 */

public class Example05 {
    public static void main(String[] args) {
        String[] arrayName = new String[] {"Maria", "Bob", "Alex"};
        for (int i = 0; i < arrayName.length; i++){
            System.out.println(arrayName[i]);
        }
        System.out.println("======");
        for (String names : arrayName){ //for each
            System.out.println(names);
        }
    }
}