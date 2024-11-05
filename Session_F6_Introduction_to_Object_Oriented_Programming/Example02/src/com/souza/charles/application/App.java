package com.souza.charles.application;

import java.util.Scanner;
import com.souza.charles.entities.Triangle;
import static com.souza.charles.entities.Triangle.calculateAreaTriangle;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();
        double sideC = scanner.nextDouble();

        Triangle triangleX = new Triangle(sideA, sideB, sideC);
        System.out.printf("Triangle X area: %.4f\n", calculateAreaTriangle (sideA, sideB, sideC));

        scanner.close();
    }
}

