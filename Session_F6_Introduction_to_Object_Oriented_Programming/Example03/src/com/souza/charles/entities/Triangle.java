package com.souza.charles.entities;

public class Triangle {
    public double sideA, sideB, sideC;

    public Double calculateAreaTriangle (){
        double  perimeter = (sideA + sideB + sideC) / 2.0;
        return  Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
    }
}
