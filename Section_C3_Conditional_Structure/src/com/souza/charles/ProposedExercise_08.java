package com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 26, 2024
*/
/**
Exercise 08: Read a value with two decimal places, 
equivalent to a person's salary. Then, calculate and 
display the amount this person must pay in Income Tax, 
according to the table below:
_____________________________________________________
Income                                     Income Tax
_____________________________________________________
from R$0.00 to R$2000.00                       Exempt
from R$2000.01 to R$3000.00                        8%
from R$3000.01 to R$4500.00                       18%
above R$4500.00                                   28%
_____________________________________________________

Remember that if the salary is R$3002.00, the applicable 
rate is 8% only on R$1000.00, as the salary range from R$0.00 
to R$2000.00 is exempt from Income Tax. In the provided example(below), 
the rate is 8% on R$1000.00 + 18% on R$2.00, resulting in a total of R$80.36. 
The value should be printed with two decimal places.

Examples:
________________________
Input             Output
________________________
3002.00          R$80.36   
1701.12           Exempt  
4520.00         R$355.60
________________________
*/
import java.util.Scanner;

public class ProposedExercise_08 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double salary = scanner.nextDouble();
		double incomeTax = 0;
		if (salary <= 2000.00) {
			System.out.println("Exempt");
		} else if (salary <= 3000.00) {
			incomeTax = (salary - 2000.00) * 0.08;
			System.out.printf("R$%.2f\n", incomeTax);
		} else if (salary <= 4500.00) {
			incomeTax = 1000.00 * 0.08 + (salary - 3000.00) * 0.18;
			System.out.printf("R$%.2f\n", incomeTax);
		} else {
			incomeTax = 1000.00 * 0.08 + 1500.00 * 0.18 + (salary - 4500.00) * 0.28;
			System.out.printf("R$%.2f\n", incomeTax);
		}
		scanner.close();

	}

}