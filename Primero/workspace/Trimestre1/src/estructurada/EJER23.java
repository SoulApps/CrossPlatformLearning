package estructurada;

import java.util.Random;
import java.util.Scanner;

public class EJER23 {

	public static void main(String[] args) {

		final byte INTENTOS = 4;
		int inf, sup;
		int adiv = 0, chance = INTENTOS, num = 0;
		String bienvenida = "Introduzca un n�mero por favor";
		String intentos = "Tiene %d intentos\n";
		String ulose = "GAME OVER NOOB";

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca el l�mite menor");
		inf = teclado.nextInt();
		System.out.println("Introduzca el l�mite mayor");
		sup = teclado.nextInt();

		Random rnd = new Random();
		adiv = rnd.nextInt((sup - inf) + 1) + inf;

		do {
			System.out.println(bienvenida);
			System.out.printf(intentos, chance);
			num = teclado.nextInt();
			if (num == adiv) {
				System.out.println("�Has ganado, enhorabuena!");
				chance = 0;
			} else {
				chance--;
				
				System.out.println("�Oh no!, �se ha equivocado!");
				if (chance == 0)
					System.out.println(ulose);
				else if (num > adiv)
					System.out.println("El n�mero es menor");
				else if (num < adiv)
					System.out.println("El n�mero es mayor");

			}
		} while (chance > 0);

		teclado.close();
	}

	
}
