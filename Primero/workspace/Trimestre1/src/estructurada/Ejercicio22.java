package estructurada;

import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {

		int n = 0, i = 0, j = 0, k = 0;
		final char ESPACIO = ' ';
		final String ASTERISCO = "* ";
		String mensaje = "Introduzca un número.";
		Scanner teclado = new Scanner(System.in);

		System.out.println(mensaje);
		n = teclado.nextInt();

		for (i = 0; i < n; i++) {
			for (j = 0; j <= n - i; j++) {
				System.out.print(ESPACIO);
			}
			for (k = 0; k <= i; k++) {
				System.out.print(ASTERISCO);
			}
			System.out.println("");
		}

		teclado.close();

	}

}
