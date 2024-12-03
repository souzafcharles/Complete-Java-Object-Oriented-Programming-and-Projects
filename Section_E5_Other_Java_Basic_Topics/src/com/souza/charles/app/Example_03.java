package com.souza.charles.app;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: August 01, 2024
*/
import java.util.Scanner;
public class Example_03 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int mask = 0b100000;
    int n = sc.nextInt();
    if ((n & mask) == 0) {
        System.out.println("6th bit is false!");
    } else {
        System.out.println("6th bit is true!");
    }
    sc.close();
  }
}