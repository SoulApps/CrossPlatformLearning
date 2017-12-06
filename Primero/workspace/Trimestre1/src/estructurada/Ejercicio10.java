package estructurada;

import java.util.Random;

public class Ejercicio10 {

	public static void main(String[] args) {

		int n, i;
		Random rnd = new Random();
		rnd.nextInt(5);

		for (i = 0; i < 20; i++) {
			n = rnd.nextInt(6) + 1;
			System.out.println(n);
		}
	}

}
