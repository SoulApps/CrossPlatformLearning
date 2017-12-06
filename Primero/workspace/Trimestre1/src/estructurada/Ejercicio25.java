package estructurada;

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		int n = 0, i = 0, j = 0, k = 0, l = 0;
		final char ESPACIO = ' ';
		String mensaje = "Introduzca un número.";
		Scanner teclado = new Scanner(System.in);

		System.out.println(mensaje);
		n = teclado.nextInt();

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n - i; j++) {
				System.out.printf("%c%c", ESPACIO, ESPACIO);
			}
			for (k = 1; k <= i; k++) {
				System.out.print(k + " ");
				if (k == i) {
					for (l = k - 1; l > 0; l--) { // k-1 es para que no me saque
													// el número más alto 2
													// veces
						System.out.print(l + " ");
					}
				}
			}
			System.out.println("");
		}
		teclado.close();
	}

}
