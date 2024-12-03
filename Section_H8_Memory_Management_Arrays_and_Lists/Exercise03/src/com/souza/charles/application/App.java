package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 15, 2024
 */
import com.souza.charles.entities.Person;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many people will be entered? ");
        int N = scanner.nextInt();
        Person[] arrayPerson = new Person[N];

        for (int i = 0; i < arrayPerson.length; i++) {
            scanner.nextLine();
            System.out.println("Data of the " + (i + 1) + "º person: ");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Height: ");
            double height = scanner.nextDouble();
            arrayPerson[i] = new Person(name, age, height);
        }

        double averageHeightOfPeopleResults = Person.calculateAverageHeight(arrayPerson);
        System.out.printf("Average height: %.2f%n", averageHeightOfPeopleResults);

        double countPeopleUnder16YearsOldResults = Person.countPeopleUnder16YearsOld(arrayPerson);
        System.out.printf("People under 16 years old: %.1f%%%n", countPeopleUnder16YearsOldResults);

        String namePeopleUnder16YearsOldResults = Person.namePeopleUnder16YearsOld(arrayPerson);
        System.out.printf("%s%n", namePeopleUnder16YearsOldResults);

        scanner.close();
    }
}
