package com.souza.charles.model.utils;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 24, 2024
 */

import com.souza.charles.model.entities.Shape;
import java.util.List;

public class ShapeCalculation {

    public double totalArea(List<? extends Shape> shapeList) {
        double sum = 0.0;
        for (Shape shape : shapeList) {
            sum += shape.area();
        }
        return sum;
    }
}