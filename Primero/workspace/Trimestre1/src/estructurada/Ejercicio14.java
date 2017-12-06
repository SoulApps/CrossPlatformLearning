package estructurada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {

		int x = 0, y = 0, i = 0, par = 0, impar = 0;
		boolean error = false;
		String mensaje = "Introduzca dos n�meros enteros";
		String mensajeError = "�El segundo valor debe ser mayor que el segundo!";
		Scanner teclado = new Scanner(System.in);

		// Petici�n de datos
		do {
			try {
				x = teclado.nextInt();
				y = teclado.nextInt();
				if (x >= y) {
					System.out.println(mensajeError);
					error = false;
				} else
					error = true;
			} catch (InputMismatchException e) {
				System.out.println(mensaje);
				teclado.nextLine();
			}
		} while (!error);

		// C�lculos
		for (i = x; i <= y; i++) {
			if (i % 2 != 0)
				impar += i;
			else
				par += i;
		}

		System.out.println("Suma impar = " + impar);
		System.out.println("Suma par = " + par);
		teclado.close();
	}

}
