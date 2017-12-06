package estructurada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio18 {
	/* 1.- Petición de datos
	 * 2.- Hacer un bucle que me vaya dando la vuelta al número hasta 3 cifras
	 * 3.- Imprimir resultado
	 */

	public static void main(String[] args) {
		// Declaración
		int x = 0, y = 0, i;
		boolean error = false;
		String mensaje = "Introduzca un número positivo.";
		String mensajeError = "¡El dato introducido debe ser un n�mero positivo!";
		;
		Scanner teclado = new Scanner(System.in);

		// Petición de datos
		do {
			try {
				System.out.println(mensaje);
				x = teclado.nextInt();
				error=false;
				if (x <= 99 || x>=1000){
					System.out.println(mensajeError);
					error = true;
				}
			} catch (InputMismatchException e) {
				System.out.println(mensajeError);
				teclado.next();
				error = true;
			}
		} while (error);

		// Operaciones
		/*
		 * El resto del número dividido entre 10 es igual al �ltimo n�mero de x
		 * y se continúa esta operación con el cociente. 
		 * /* 123%10=3 &&
		 * 123/10=12 12%10=2 && 12/10=1 1%10=1;
		 */

		for (i = 0; i < 3; i++) {
			y = x % 10;	//Uso una variable auxiliar para guardar el resultado
			x /= 10;
			System.out.print(y);
		}

		teclado.close();
	}

}
