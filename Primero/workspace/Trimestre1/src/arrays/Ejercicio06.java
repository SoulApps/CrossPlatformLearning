package arrays;

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		
		int array[] = new int [5];
		int array2[] = new int [array.length];
		int i, j;
		
		Scanner teclado = new Scanner(System.in);
		
		for (i = 0; i < array.length; i++) {
			array[i] = teclado.nextInt();
		}
		
		for (i = 0, j = array.length - 1; i < array.length; i++, j--) {
			array2[j] = array[i];
		}
		
		for (i = 0; i < array.length; i++)
			System.out.print(array[i]);

		System.out.println();

        for (i = 0; i < array.length; i++)
			System.out.print(array2[i]);
		teclado.close();
	}

}
