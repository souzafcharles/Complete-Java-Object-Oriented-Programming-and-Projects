package com.souza.charles;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int evenQuantity = 0;
        System.out.print("How many numbers are you going to enter? ");
        int N = scanner.nextInt();
        int[] number = new int[N];
        for (int i = 0; i < number.length; i++) {
            System.out.print("Enter a number: ");
            number[i] = scanner.nextInt();
        }
        System.out.println("EVEN NUMBERS: ");
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                System.out.printf("%d ", number[i]);
                evenQuantity++;
            }
        }
        System.out.printf("%nQUANTITY OF EVEN NUMBERS = %d", evenQuantity);
        scanner.close();
    }
}
