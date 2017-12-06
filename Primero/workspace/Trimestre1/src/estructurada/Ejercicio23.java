package estructurada;

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {

		int n = 0, i = 0, j = 0, k = 0;
		final char ESPACIO = ' ';
		final String ROMBETE = "♦ ";
		String mensaje = "Introduzca un número.";
		Scanner teclado = new Scanner(System.in);

		System.out.println(mensaje);
		n = teclado.nextInt();

		for (i = 0; i < n; i++) {
			for (j = 0; j <= n - i; j++) {
				System.out.print(ESPACIO);
			}
			for (k = 0; k <= i; k++) {
				System.out.print(ROMBETE);
			}
			System.out.println("");
		}

		// Piramide del revés
		for (i = 1; i < n; i++) {
			for (j = 0; j <= i + 1; j++) {
				System.out.print(ESPACIO);
			}
			for (k = 0; k <= n - j + 1; k++) {
				System.out.print(ROMBETE);
			}
			System.out.println("");
		}
		teclado.close();

	}

}
