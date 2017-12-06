package arrays;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		int i;
		int array[] = new int[5];
		Scanner teclado = new Scanner(System.in);

		// Introducción de datos
		for (i = 0; i < array.length; i++) {
			array[i] = teclado.nextInt();
		}

		// Lectura
		for (i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0)
				System.out.printf("El dato %d de la posición %d es par\n",array[i], i);
			else
				System.out.printf("El dato %d de la posición %d es impar\n", array[i], i);
		}
		teclado.close();

	}

}
