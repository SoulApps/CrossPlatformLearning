package cadenas;

import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {

		String s1, s2, resultado;
		
		Scanner teclado = new Scanner(System.in);
		
		s1 = teclado.nextLine();
		s2 = teclado.nextLine();
		teclado.close();
		
		resultado = s1.concat(s2);
		System.out.println(resultado);

	}

}
