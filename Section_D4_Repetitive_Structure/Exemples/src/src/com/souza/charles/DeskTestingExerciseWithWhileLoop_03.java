package src.com.souza.charles;

/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc. 
 * Exercise done by: Charles Fernandes de Souza 
 * Date: April 10, 2024
*/
public class DeskTestingExerciseWithWhileLoop_03 {

	public static void main(String[] args) {

		int x = 4;
		int y = 0;
		int i = 0;
		while (i < x) {
			i = i + 1;
			y = y + i;
			System.out.print(i);
			System.out.println(y);
		}

	}

}
