package arrays;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		int i;
		int array[] = new int[5];
		Scanner teclado = new Scanner(System.in);

		//Introducción de datos
		for (i = 0; i < array.length; i++) {
			array[i] = teclado.nextInt();
		}
		
		//Lectura
		for (i = 0; i < array.length; i++) {
			if (i % 2 ==0) 
				System.out.println(array[i]);
		}
		teclado.close();
	}

}
