package estructurada;

import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {

		int x, y, resultado = 0, i;
		String mensaje = "Introduzca 2 números positivos.";
		Scanner teclado = new Scanner(System.in);

		//Petición de datos al usuario controlando que los números sean positivos
		do {
			System.out.println(mensaje);
			x = teclado.nextInt();
			y = teclado.nextInt();
		} while (x <= 0 || y <= 0);

		//Creo un bucle usando el segundo número como límite de sumas
		for (i = 0; i < y; i++) {
			resultado += x; //Sumarle x al resultado
			System.out.println(resultado); //Muestro resultado
		}

		teclado.close();

	}

}
