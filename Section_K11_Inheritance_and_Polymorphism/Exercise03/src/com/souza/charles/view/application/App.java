package com.souza.charles.view.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 27, 2024
 */
import com.souza.charles.model.entities.Circle;
import com.souza.charles.model.entities.Rectangle;
import com.souza.charles.model.entities.Shape;
import com.souza.charles.model.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();
        System.out.print("Enter the number of shapes: ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            scanner.nextLine();
            System.out.println("Shape #" + (1 + i) + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char isRectangleOrCircle;
            isRectangleOrCircle = Character.toLowerCase(scanner.next().charAt(0));
            System.out.print("Color (BLACK/BLUE/RED): ");
            scanner.nextLine();
            String color = scanner.nextLine();
            if (isRectangleOrCircle == 'r') {
                System.out.print("Width: ");
                Double width = scanner.nextDouble();
                System.out.print("Height: ");
                Double height = scanner.nextDouble();
                shapes.add(new Rectangle(Color.valueOf(color), width, height));
            } else {
                System.out.print("Radius: ");
                Double radius = scanner.nextDouble();
                shapes.add(new Circle(Color.valueOf(color), radius));
            }
        }
        System.out.print("\nSHAPE AREAS:\n");
        for (Shape shape : shapes) {
            System.out.printf("%.2f%n", shape.area());
        }
        scanner.close();
    }
}