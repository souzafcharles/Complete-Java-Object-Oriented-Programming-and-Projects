package com.souza.charles;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many values will each array have? ");
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        System.out.println("Enter the values of array A: ");
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println("Enter the values of array B: ");
        for (int i = 0; i < B.length; i++) {
            B[i] = scanner.nextInt();
        }
        System.out.println("RESULTANT ARRAY: ");
        for (int i = 0; i < C.length; i++) {
            C[i] = A[i] + B[i];
            System.out.println(C[i]);
        }
        scanner.close();
    }
}
