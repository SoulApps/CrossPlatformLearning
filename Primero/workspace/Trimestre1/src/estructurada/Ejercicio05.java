package estructurada;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		int n1, n2, n3;

		Scanner teclado = new Scanner(System.in);

		n1 = teclado.nextInt();
		n2 = teclado.nextInt();
		n3 = teclado.nextInt();

		if (n1 < n2 && n2 < n3)
			System.out.printf("%d %d %d", n1, n2, n3);

		else if (n2 < n1 && n1 < n3)
			System.out.printf("%d %d %d", n2, n1, n3);

		else if (n3 < n2 && n2 < n1)
			System.out.printf("%d %d %d", n3, n2, n1);

		else if (n3 < n1 && n1 < n2)
			System.out.printf("%d %d %d", n3, n1, n2);

		else if (n2 < n3 && n3 < n1)
			System.out.printf("%d %d %d", n2, n3, n1);

		else
			System.out.printf("%d %d %d", n1, n3, n2);

		teclado.close();

	}

}
