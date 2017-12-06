package estructurada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		// Declaraci�n
		int n = 0, i, x = 1; // Es importante inicializar a 1 para que el
								// resultado no sea 0
		boolean error = false;
		String mensaje = "Introduzca un número positivo.";
		String mensajeError = "¡El dato introducido debe ser un n�mero positivo!";
		Scanner teclado = new Scanner(System.in);

		// Petición de datos
		do {
			try {
				System.out.println(mensaje);
				n = teclado.nextInt();
				if (n <= 0) {
					System.out.println(mensajeError);
				}
				error = true;
			} catch (InputMismatchException e) {
				System.out.println(mensajeError);
				error = true;
			}
		} while (!error);

		for (i = 1; i <= n; i++) {
			x *= i;
		}

		System.out.println(x);

		teclado.close();
	}

}
