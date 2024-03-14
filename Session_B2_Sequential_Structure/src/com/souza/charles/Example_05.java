package com.souza.charles;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date:  March 14, 2024
*/

public class Example_05 {

	public static void main(String[] args) {
	    //Calculates the area of a trapezoid given two parallel bases and the height.
        double b, B, h, area;
       
        b = 6.0;
        B = 8.0;
        h = 5.0;
        
        area = (b + B) / 2.0 * h;
        
        System.out.println(area);
	}
}
