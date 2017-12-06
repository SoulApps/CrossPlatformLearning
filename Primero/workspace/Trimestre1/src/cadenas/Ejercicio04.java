package cadenas;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		String s;
		char caracter;

		Scanner teclado = new Scanner(System.in);

		s = teclado.nextLine();
		caracter = teclado.next().charAt(0);
		teclado.close();

		s = s.replaceAll("[^caracter]", "");
		System.out.printf("El caracter %s aparece %d veces",caracter, s.length());
		
	}

}
