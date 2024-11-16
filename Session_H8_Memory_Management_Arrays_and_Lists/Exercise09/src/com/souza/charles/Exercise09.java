package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int oldestPerson = 0;
        String oldestPersonName = "";
        System.out.print("How many people will you enter? ");
        int N = scanner.nextInt();
        String[] peopleName = new String[N];
        int[] peopleAge = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Data of the "+(1 + i)+"º person: ");
            scanner.nextLine();
            System.out.print("Name: ");
            peopleName[i] = scanner.nextLine();
            System.out.print("Age: ");
            peopleAge[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (peopleAge[i] > oldestPerson) {
                oldestPerson = peopleAge[i];
                oldestPersonName = peopleName[i];
            }
        }
        System.out.println("OLDEST PERSON: " + oldestPersonName);
        scanner.close();
    }
}
