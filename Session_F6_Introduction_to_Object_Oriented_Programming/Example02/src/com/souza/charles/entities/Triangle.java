package com.souza.charles.entities;

public class Triangle {

    double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public static Double calculateAreaTriangle (double sideA, double sideB, double sideC){
        double  perimeter = (sideA + sideB + sideC) / 2.0;
        return  Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
    }

}

