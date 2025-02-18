package src.com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 06: Create a program that reads three double-precision floating-point values: 
A, B, and C. Then, calculate and display:
a) the area of the right-angled triangle with A as its base and C as its height.
b) the area of the circle with radius C. (pi = 3.14159)
c) the area of the trapezium with A and B as its bases and C as its height.
d) the area of the square with side B.
e) the area of the rectangle with sides A and B."
*/
import java.util.Scanner;

public class ProposedExercise06 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double A = scanner.nextDouble();
		double B = scanner.nextDouble();
		double C = scanner.nextDouble();
		double areaTriangle = 0.5 * A * C;
		double areaCircle = Math.PI * Math.pow(C, 2);
		double areaTrapezium = 0.5 * (A + B) * C;
		double areaSquare = Math.pow(B, 2);
		double areaRectangle = A * B;
		System.out.printf("Area of the right-angled triangle: %.3f ", areaTriangle);
		System.out.printf("\nArea of the circle: %.3f ", areaCircle);
		System.out.printf("\nArea of the trapezium: %.3f ", areaTrapezium);
		System.out.printf("\nArea of the square: %.3f ", areaSquare);
		System.out.printf("\nArea of the rectangle: %.3f ", areaRectangle);
		scanner.close();
		
	}	
}
