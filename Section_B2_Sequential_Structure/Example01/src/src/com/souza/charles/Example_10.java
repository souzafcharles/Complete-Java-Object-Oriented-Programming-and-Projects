package src.com.souza.charles;

/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc. 
 * Example adapted by: Charles Fernandes de Souza 
 * Date: March 19, 2024
 */

public class Example_10 {

	public static void main(String[] args) {

		double x = 3.0;
		double y = 4.0;
		double z = -5.0;
		double A, B, C;
		A = Math.sqrt(x);
		B = Math.sqrt(y);
		C = Math.sqrt(25.0);
		System.out.println("The square root " + x + " is " + A);
		System.out.println("The square root " + y + " is " + B);
		System.out.println("The square root of 25 is " + C);
		A = Math.pow(x, y);
		B = Math.pow(x, 2.0);
		C = Math.pow(5.0, 2.0);
		System.out.println(x + " elevated to " + y + " is " + A);
		System.out.println(x + " elevated to the square is " + B);
		System.out.println("5 elevated to the squareis " + C);
		A = Math.abs(y);
		B = Math.abs(z);
		System.out.println("The absolute value of " + y + " is " + A);
		System.out.println("The absolute value of " + z + " is " + B);
	}
}
