package estructurada;

import java.util.Scanner;

public class Ejemplo5 {

	public static void main(String[] args) {

		int n1 = 0, n2 = 0, i;
		Scanner teclado = new Scanner(System.in);

		n1 = teclado.nextInt();
		n2 = teclado.nextInt();
		teclado.close();

		for (i = n1; i <= n2; i++) {
			if (i % 2 == 0)
				System.out.println(i);
		}


	}

}
