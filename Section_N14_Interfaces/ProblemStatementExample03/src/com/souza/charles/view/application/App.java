package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 15, 2024
 */

import com.souza.charles.model.entities.Circle;
import com.souza.charles.model.entities.Rectangle;
import com.souza.charles.model.entities.Shape;
import com.souza.charles.model.enums.Color;

public class App {

    public static void main(String[] args) {

        Shape shape01 = new Circle(Color.RED, 2.0);
        Shape shape02 = new Rectangle(Color.BLUE, 3.0, 4.0);

        System.out.println("Circle color: " + shape01.getColor());
        System.out.println("Circle area: " + String.format("%.3f", shape01.area()));
        System.out.println("Rectangle color: " + shape02.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f", shape02.area()));
    }
}
