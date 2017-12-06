package cadenas;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		String s;
		
		Scanner teclado = new Scanner(System.in);
		
		s = teclado.nextLine();
		teclado.close();

		s.toLowerCase();
		s = s.replaceAll("[^aeiouáéíóú]", "");
		System.out.printf("Hay %d vocales", s.length());

	}

}
