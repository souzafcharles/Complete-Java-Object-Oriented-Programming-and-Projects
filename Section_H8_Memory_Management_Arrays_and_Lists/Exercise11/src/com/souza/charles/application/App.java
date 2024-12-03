package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
import com.souza.charles.entities.Person;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many elements will you enter? ");
        int N = scanner.nextInt();
        Person[] person = new Person[N];
        for (int i = 0; i < person.length; i++) {
            scanner.nextLine();
            System.out.print("Height of the " + (1 + i) + "º person: ");
            double height = scanner.nextDouble();
            System.out.print("Gender of the " + (1 + i) + "º person: ");
            char gender = Character.toUpperCase(scanner.next().charAt(0));
            person[i] = new Person(height, gender);
        }
        double shortestHeight = Person.calculateShortestHeight(person);
        double tallestHeight = Person.calculateTallestHeight(person);
        double averageHeightOfWomen = Person.calculateAverageHeightOfWomen(person);
        int numberOfMen = Person.calculateNumberOfMen(person);
        System.out.printf("Shortest height: %.2f%n", shortestHeight);
        System.out.printf("Tallest height: %.2f%n", tallestHeight );
        System.out.printf("Average height of women: %.2f%n", averageHeightOfWomen);
        System.out.printf("Number of men: %d%n", numberOfMen);
        scanner.close();
    }
}
