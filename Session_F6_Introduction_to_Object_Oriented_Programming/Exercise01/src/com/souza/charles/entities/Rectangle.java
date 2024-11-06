package com.souza.charles.entities;

public class Rectangle {

    public double width, height;

    public Double calculateArea() {
        return width * height;
    }

    public Double calculatePerimeter() {
        return 2 * (width + height);
    }

    public Double calculateDiagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
