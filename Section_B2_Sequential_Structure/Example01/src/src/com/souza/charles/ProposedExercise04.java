package src.com.souza.charles;

/**
Course title: Complete Java - Object-Oriented Programming + Projects
Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
Exercise done by: Charles Fernandes de Souza
Date: March 21, 2024
*/
/**
Exercise 04: Write a program that reads the employee's number, 
the number of hours worked, the hourly rate, 
and calculates the employee's salary. 
Then, display the employee's number and salary, rounded to two decimal places.
*/
import java.util.Scanner;

public class ProposedExercise04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int employeeNumber = scanner.nextInt();
		double numberOfHoursWorked = scanner.nextDouble();
		double hourlyRate = scanner.nextDouble();
		double employeeSalary = numberOfHoursWorked * hourlyRate;
		System.out.printf("The employee's number is %d and salary is $ %.2f", employeeNumber, employeeSalary);
		scanner.close();
	
	}
	
}
