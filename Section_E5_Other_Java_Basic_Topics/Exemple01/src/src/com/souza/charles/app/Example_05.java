package src.com.souza.charles.app;
/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: August 03, 2024
*/
/*
This programme calculates the roots of a quadratic equation
The coefficient values should be entered one per line
*/
import java.util.Locale;
import java.util.Scanner;
public class Example_05 {
	public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        Scanner scanner = new Scanner(System.in);
        double a, b, c, delta;
        System.out.println("Enter the coefficient values: ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        delta = b * b - 4 * a * c; // calculation of the delta value
        scanner.close();        
        
    }

}