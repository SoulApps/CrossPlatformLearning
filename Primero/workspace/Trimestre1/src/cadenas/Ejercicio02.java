package cadenas;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		String s1, s2;
		
		Scanner teclado = new Scanner(System.in);
		
		s1 = teclado.nextLine();
		s2 = s1.replace(" ", "");
		System.out.println(s2);

		teclado.close();
	}

}
