package com.souza.charles.view.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> C = new HashSet<>();
        System.out.print("How many students for course A? ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int uniqueCode = scanner.nextInt();
            A.add(uniqueCode);
        }
        System.out.print("How many students for course B? ");
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int uniqueCode = scanner.nextInt();
            B.add(uniqueCode);
        }
        System.out.print("How many students for course C? ");
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int uniqueCode = scanner.nextInt();
            C.add(uniqueCode);
        }
        Set<Integer> total = new HashSet<>(A);
        total.addAll(B);
        total.addAll(C);
        System.out.println("Total students: " + total.size());
        scanner.close();
    }
}

