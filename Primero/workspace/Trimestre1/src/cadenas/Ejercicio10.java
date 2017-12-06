package cadenas;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {

		int i;
		String s, resultado;
		Scanner teclado = new Scanner(System.in);
		
		s = teclado.nextLine();
		teclado.close();
		
		for (i = s.length()-1; i >= 0; i--) {
			resultado = s.charAt(i) + "";
			System.out.print(resultado);
		}
	}

}
