import java.util.Scanner;

public class Ejercicio23 {
	/**
	 * Escribe un algoritmo que lea un número natural n y un carácter por
	 * teclado. La salida debe ser un rombo compuesto del carácter y de la
	 * anchura que especifica el número n.
	 **/
	public static void main(String[] args) {

		// Declaramos variables y el objeto teclado
		Scanner teclado = new Scanner(System.in);
		char caracter;
		int n, linea, i;
		final char ESPACIO=' ';

		// Pedimos datos al usuario.
		System.out
				.print("Introduce un caracter para formar un rombo.\nCaracter: ");
		caracter = teclado.nextLine().charAt(0);
		do {
			System.out
					.print("Introduce una anchura, el valor debe ser positivo y desigual a 0.\nAnchura: ");
			n = teclado.nextInt();
			if (n <= 0)
				System.out.println("¡Error!");
		} while (n <= 0);

		// Imprimimos piramide ascendente.
		// Imprimimos linea por linea
		for (linea = 1; linea <= n; linea++) {
			// imprimos espacios: n-linea
			for (i = 1; i <= n-linea; i++)
				System.out.print(ESPACIO);
			// determino un bloque: caracter+espacio
			// imprimo bloques: linea
			for (i = 1; i <= linea; i++)
				System.out.printf("%c%c",caracter,ESPACIO);
			System.out.println();
		}
		
		// Imprimimos piramide descendente.
		// Imprimimos linea por linea
		for (linea = 1; linea <= n-1; linea++) {
			// Imprimos espacios: linea
			for (i = 1; i <= linea; i++)
				System.out.print(ESPACIO);
			// Determino un bloque: caracter+espacio
			// Imprimo bloques: n-linea
			for (i = 1; i <= n-linea; i++)
				System.out.printf("%c%c",caracter,ESPACIO);
			System.out.println();
		}

		// Cerrar teclado
		teclado.close();
	}

}
