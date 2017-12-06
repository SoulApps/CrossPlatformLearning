package estructurada;

import java.util.Scanner;

public class Ejemplo3 {

	public static void main(String[] args) {

		int x = 0;
		Scanner teclado = new Scanner(System.in);

		x = teclado.nextInt();

		if (x % 2 == 0)
			System.out.println("Par");
		else
			System.out.println("Impar");
		
		teclado.close();

	}

}
