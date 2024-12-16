package com.souza.charles.view.application;

import com.souza.charles.model.entities.AbstractShape;
import com.souza.charles.model.entities.Circle;
import com.souza.charles.model.entities.Rectangle;
import com.souza.charles.model.enums.Color;

public class App {

    public static void main(String[] args) {

        AbstractShape shape01 = new Circle(Color.RED, 2.0);
        AbstractShape shape02 = new Rectangle(Color.BLUE, 3.0, 4.0);

        System.out.println("Circle color: " + shape01.getColor());
        System.out.println("Circle area: " + String.format("%.3f", shape01.area()));
        System.out.println("Rectangle color: " + shape02.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f", shape02.area()));
    }
}
