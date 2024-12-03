package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Example adapted by: Charles Fernandes de Souza
Date: April 09, 2024
*/
import java.util.Scanner;

public class Example_05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double price = 400.00;
		double discount;
		if (price < 200.00) {
			discount = price * 0.1;
		} else {
			discount = 0;
		}
		System.out.println(discount);
		scanner.close();
	}

}
