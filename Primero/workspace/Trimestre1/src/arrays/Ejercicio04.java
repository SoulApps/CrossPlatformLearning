package arrays;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		int array[] = new int [5];
		int i, aux = 0;
		Scanner teclado = new Scanner(System.in);
		
		for (i = 0; i < array.length; i++) {
			array[i] = teclado.nextInt();
		}
		
		for (i = 0; i < array.length; i++) {
			if (array[i] % 2 !=0) {
				aux += array[i];
				System.out.println(aux);
			}
		}

		teclado.close();
	}

}
