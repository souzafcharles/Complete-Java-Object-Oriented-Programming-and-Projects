package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
import com.souza.charles.entities.Rent;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rooms will be rented? ");
        int N = scanner.nextInt();
        Rent[] rent = new Rent[N];
        for (int i = 0; i < rent.length; i++) {
            scanner.nextLine();
            System.out.println("Rent #"+(1+i)+":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Room: ");
            int room = scanner.nextInt();
            rent[i] = new Rent(name, email, room);
        }
        Rent.sortRentsByRoom(rent);
        System.out.println("Occupied rooms:");
        for (int i = 0; i < rent.length; i++) {
            System.out.println(rent[i]);
        }
        scanner.close();
    }
}