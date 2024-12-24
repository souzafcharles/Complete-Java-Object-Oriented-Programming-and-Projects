package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 24, 2024
 */

import com.souza.charles.model.entities.Circle;
import com.souza.charles.model.entities.Rectangle;
import com.souza.charles.model.entities.Shape;
import com.souza.charles.model.utils.ShapeCalculation;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ShapeCalculation shapeCalculation = new ShapeCalculation();
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Rectangle(3.0, 2.0));
        shapeList.add(new Circle(2.0));
        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(2.0));
        circleList.add(new Circle(3.0));
        System.out.printf("Total area: %.3f%n", shapeCalculation.totalArea(shapeList));
        System.out.printf("Total area: %.3f%n", shapeCalculation.totalArea(circleList));
    }
}