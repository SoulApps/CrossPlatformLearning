package examen;

import static examen.Colores.*;

import java.util.Random;
import java.util.Scanner;

public class Funciones {

	//static String color1, color2;

	public static void main(String[] args) {

        final String AMARILLO_AZUL = "\u001B[43;34m";
        final String AZUL_AMARILLO = "\u001B[33;44m";

		int linea, i, colorAleatorio, longitudPalabra;
		String palabra;
		EnumColor color = EnumColor.NORMAL;
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		// 1. Petición de una palabra al usuario de hasta 20 caracteres
		do {
			System.out.print("Introduzca una palabra de hasta 20 caracteres como máximo que no contenga espacios: ");
			palabra = teclado.next();
			if (palabra.length() > 20)
				System.out.println("La palabra contiene más de 20 caracteres");
		} while (palabra.length() > 20);
		teclado.close();
		longitudPalabra = palabra.length();
		/*
		 * 2. Elección aleatoria de los colores: - Normal - Rojo-verde -
		 * Azul-amarillo
		 */
		colorAleatorio = aleatorio.nextInt(3);
		switch (colorAleatorio) {
			case 0:
				color = EnumColor.NORMAL;
				break;
			case 1:
				color = EnumColor.ROJOVERDE;
				break;
			case 2:
				color = EnumColor.AZULAMARILLO;
				break;
		}

		//Funciones.cogerColorMiVersion(color);

		// 3. Realizar un bucle para que recorra cada una de las líneas, que se
		// ejecute tantas veces como la longitud de la palabra
		for (linea = 1; linea <= longitudPalabra; linea++)
			if (linea == 1) { // 3.1 Si es la primera línea, escribir todos los
				// caracteres de la cadena
				for (i = 0; i < longitudPalabra; i++)
                    dibujar(color, palabra.charAt(i), ROJO, AZUL_AMARILLO);
                System.out.println();
			} else if (linea == longitudPalabra) { // 3.2 Si es la última línea,
				// escribir todos los
				// caracteres de la cadena
				// al revés
				for(i = longitudPalabra-1;i >= 0;i--)
					dibujar(color,palabra.charAt(i),ROJO,AZUL_AMARILLO);

				System.out.printf("%n");
			} else { // 3.3 Si es cualquier línea excepto la primera y la
				// última, realizar un bucle que se ejecute tantas veces
				// como la longitud de la cadena
				for (i = 0; i < longitudPalabra; i++)
					if (i == 0) { // 3.3.1 Si es el primer carácter: escribir el
						// carácter de la cadena correspondiente al
						// número de línea. Ej: en la línea 2, escribir
						// el segundo carácter de la cadena
						dibujar(color, palabra.charAt(linea - 1), VERDE, AMARILLO_AZUL);
					} else if (i == longitudPalabra - 1) { // 3.3.2 Si es el último
						// carácter: escribir el
						// carácter de la cadena
						// empezando por el
						// final correspondiente
						// al número de línea.
						// Ej: en la línea 2,
						// escribir el segundo
						// carácter de la cadena
						// empezando por el
						// final, es decir, el
						// penúltimo
						dibujar(color, palabra.charAt(longitudPalabra - linea), VERDE, AMARILLO_AZUL);
					} else // 3.3.3 Si es cualquier carácter excepto el primero o
						// el último: escribir un espacio
						System.out.printf("%c", ' ');
				System.out.printf("%n");
			}
	}

	/*
	public static void cogerColorMiVersion(EnumColor color) {

		switch (color) {
			case NORMAL:
				color1 = RESET;
				color2 = RESET;
				break;
			case ROJOVERDE:
				color1 = ROJO;
				color2 = VERDE;
				break;
			case AZULAMARILLO:
				color1 = AZUL_AMARILLO;
				color2 = AMARILLO_AZUL;
				break;
		}
	}
	*/

	public static void dibujar(EnumColor opcion, char caracter, String color1, String color2) {
		switch (opcion) {
			case NORMAL:
                System.out.print(caracter);
				break;
			case ROJOVERDE:
                System.out.print(color1 + caracter + RESET);
				break;
			case  AZULAMARILLO:
                System.out.print(color2 + caracter + RESET);
				break;
		}
	}
}
