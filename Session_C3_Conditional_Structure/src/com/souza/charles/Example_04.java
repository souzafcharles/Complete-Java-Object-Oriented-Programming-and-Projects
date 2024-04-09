package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: April 09, 2024
*/
import java.util.Scanner;

public class Example_04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double price = 34.5;
		double discount = (price < 20.0) ? price * 0.1 : price * 0.05;
		System.out.println(discount);
		scanner.close();
	}

}
