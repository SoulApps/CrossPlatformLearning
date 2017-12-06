package examen;

import java.util.Random;
import java.util.Scanner;

public class Examen {
	
	//Alejandro Sánchez Galvín
	
	/*
	 * 	1.-Petición de datos al usuario.
	 * 		1.1.-Controlar que tenga como máximo 20 caracteres.
	 * 	2.-Elegir combinación de colores aleatoriamente.
	 * 	3.-Darle la vuelta a las cadenas para imprimirlas luego en vertical y poner espacios entre ellos.
	 * 		3.1.-No coger ni el primer ni el último caracter de la cadena para contar los espacios.
	 * 	4.-Imprimir las cadenas. 
	 */

	public enum Colores {
		NORMAL, ROJO_VERDE, AZUL_AMARILLO
	}
	
	public static void main(String[] args) {

		final byte MAXIMO = 20, MINIMO = 1;
		final String ROJO = "\u001B[31m";
		final String VERDE = "\u001B[32m";
		final String AZUL_AMARILLO = "\u001B[34;43m";
		final String AMARILLO_AZUL = "\u001B[33;44m";
		final String RESET = "\u001B[0m";
		final String mensajeBienvenida = "Introduce una palabra de 20 caracteres como máximo.";
		final String mensajeErrorMaximo = "La longitud de la cadena es demasiado larga.";
		final String mensajeErrorMinimo = "La longitud de la cadena es demasiado corta.";
		boolean error = false;
		int aleatorio, i, j, k;
		String cadena, cadena1, cadena2, cadena3;
		char c1, c2, c3;
		Colores c = Colores.NORMAL;
		String color1 = RESET , color2 = RESET;
		Scanner teclado = new Scanner(System.in);
		Random rnd = new Random();
		
		//1.-Petición de datos al usuario.
		do {
			System.out.println(mensajeBienvenida);
			cadena = teclado.nextLine();
			//1.1.-Controlar que tenga como máximo 20 caracteres.
			if (cadena.length() > MAXIMO) {
				error = true;
				System.out.println(mensajeErrorMaximo);
			}
			else if (cadena.length() < MINIMO) {
				error = true;
				System.out.println(mensajeErrorMinimo);
			} else 
				error = false;
			
		} while (error);
		teclado.close();
		
		//2.-Elegir combinación de colores aleatoriamente.
		aleatorio = rnd.nextInt(3);
		
		switch (aleatorio) {
		case 0:
			c = Colores.NORMAL;
			break;
		case 1:
			c = Colores.ROJO_VERDE;
			color1 = ROJO;
			color2 = VERDE;
			break;
		case 2:
			c = Colores.AZUL_AMARILLO;
			color1 = AMARILLO_AZUL;
			color2 = AZUL_AMARILLO;
			break;
		}
		
		System.out.printf("El color elegido es: %s%n", c);
		
		/*3.-Darle la vuelta a las cadenas para imprimirlas luego en vertical
		 * 		3.1.-No coger ni el primer ni el último caracter.
		 */
		//4.-Imprimo resultado a la vez.
		
		//Imprimo la palabra normal.
		System.out.println(color1 + cadena + RESET);
		
		//Doy la vuelta para los caracteres  verticales.
		for (i = 1, j = cadena.length() - 2; i < cadena.length() - 1 || j > 1; i++, j--) { //Le resto a la longitud para adaptarlo
			c1 = cadena.charAt(i);															//al charAt y me coja las letras válidas.
			cadena1 = String.valueOf(c1);
			c2 = cadena.charAt(j);
			cadena2 = String.valueOf(c2);
			
			//Imprimiría 'O' [espacios] 'L' [salto de línea] en el caso de "HOLA" y luego la 'L' y la 'O' de la misma forma.
			System.out.print(color2 + cadena1 + RESET);
			
			for (k = 0; k < cadena.length() - 2; k++) //Imprimo el número de espacios tomando la longitud de la cadena como límite
				System.out.print(" ");				 // y restándole 2 para no contar el primer y el último caracter.
			
			System.out.print(color2 + cadena2 + RESET);
			System.out.println();
		}
		//Imprimo la palabra al revés.
		if (cadena.length() > 1) {	//Controlo para que no me saque dos veces el mismo caracter en caso de que solo se meta 1.
									//Ej: cadena = A; Resultado = A[salto de línea]A. Evito la última A.
			for (i = cadena.length() - 1; i >= 0; i--) {
				c3 = cadena.charAt(i);
				cadena3 = String.valueOf(c3);
				System.out.print(color1 + cadena3 + RESET);
			}
		}
		
	}

}
