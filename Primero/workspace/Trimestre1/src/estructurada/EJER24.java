package estructurada;


import java.util.Random;
import java.util.Scanner;


public class EJER24 {

	public static void main(String[] args) {

		final byte INTENTOS = 4;
		boolean comprobar = false;
		int inf, sup, n , comprobarRango;
		int adiv = 0, chance = INTENTOS;
		String intentos = "Tengo %d intento(s)\n";
		String iLose = "�He perdido!";

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca el l�mite menor");
		inf = teclado.nextInt();
		System.out.println("Introduzca el l�mite mayor");
		sup = teclado.nextInt();

		Random rnd = new Random();

		do {
			adiv = rnd.nextInt((sup - inf) + 1) + inf;
			System.out.println(adiv);
			System.out.println("�Es correcto? 1.S� 2.No");
			n = teclado.nextInt();
			if (n == 1)
				comprobar = true;
			else
				comprobar = false;

			if (comprobar == true) {
				System.out.println("�He ganado, NOOB!");
				chance = 0;
			} else {
				chance--;
				System.out.println("�Oh no!, �me he equivocado!");
				System.out.printf(intentos, chance);
				if (chance == 0) {
					System.out.println(iLose);
				}
				System.out.println("�El n�mero es mayor o menor?");
				comprobarRango = teclado.nextInt();
				if (comprobarRango == 1) {
					System.out.println("El n�mero es mayor");
					inf = adiv;
					adiv = rnd.nextInt((sup - inf) + 1) + inf;
				}
				else {
					System.out.println("El n�mero es mayor");
					sup = adiv;
					adiv = rnd.nextInt((sup - inf) + 1) + inf;
				}

			}
		} while (chance > 0);

		teclado.close();

	}

}
