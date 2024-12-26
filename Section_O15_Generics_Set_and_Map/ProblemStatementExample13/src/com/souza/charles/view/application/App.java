package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 26, 2024
 */

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        Set<Integer> A = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> B = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        //union
        Set<Integer> C = new TreeSet<>(A);
        C.addAll(B);
        System.out.println(C);
        //intersection
        Set<Integer> D = new TreeSet<>(A);
        D.retainAll(B);
        System.out.println(D);
        //difference
        Set<Integer> E = new TreeSet<>(A);
        E.removeAll(B);
        System.out.println(E);
        //difference
        Set<Integer> F = new TreeSet<>(B);
        F.removeAll(A);
        System.out.println(F);
    }
}