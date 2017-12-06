package estructurada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio12 {

	public enum Sexo {
		HOMBRE, MUJER
	}

	public static void main(String[] args) {

		final byte MIN_EDAD = 18, MAX_EDAD = 40;
		byte edad = 0, hijos = 0, sexo = 0;
		Sexo s = Sexo.HOMBRE;
		boolean error = false;
		String peticionEdad = "Introduzca su edad.";
		String peticionSexo = "Introduzca su sexo; 1.HOMBRE 2.MUJER";
		String peticionHijos = "Introduzca su número de hijos.";
		String errorEdad = "¡Debe ser mayor de edad y menor de 40 años!";
		String errorSexo = "¡Debe introducir 1 si es hombre o 0 si es mujer!";
		String errorHijos = "¡El número de hijos introducidos debe ser un número entero positivo!";
		Scanner teclado = new Scanner(System.in);

		// Edad
		do {
			try {
				System.out.println(peticionEdad);
				edad = teclado.nextByte();
				error = true;
				if (edad < MIN_EDAD || edad > MAX_EDAD)
					System.out.println(errorEdad);
				error = true;
			} catch (InputMismatchException e) {
				System.out.println(errorEdad);
				teclado.nextLine();
				error = true;
			}
		} while (!error);

		// Sexo
		do {
			try {
				System.out.println(peticionSexo);
				sexo = teclado.nextByte();
				error = true;
				if (sexo == 1)
					s = Sexo.HOMBRE;
				else if (sexo == 0)
					s = Sexo.MUJER;
				else
					System.out.println(errorSexo);
				error = true;
			} catch (InputMismatchException e) {
				System.out.println(errorSexo);
				teclado.nextLine();
				error = true;
			}
		} while (!error);

		// Hijos
		do {
			try {
				System.out.println(peticionHijos);
				hijos = teclado.nextByte();
				error = true;
				if (hijos < 0)
					System.out.println(errorHijos);
				error = true;
			} catch (InputMismatchException e) {
				System.out.println(errorSexo);
				teclado.nextLine();
				error = true;
			}
		} while (!error);

		System.out.printf(
				"Usted tiene %d años, su sexo es %s y tiene %d hijos.", edad,
				s, hijos);
		teclado.close();
	}

}
