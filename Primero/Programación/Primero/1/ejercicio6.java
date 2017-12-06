package boletinProgramacion1;

import java.util.Random;

public class Ejercicio6 {

	public static void main(String[] args) {

		int num_carta, num_palo;
		String palo = "", valor_especial = "";
		Random rnd = new Random();

		// Generamos los dos n�meros aleatorios, uno que indicar� el palo y el otro el n�mero de la carta.
		num_carta = rnd.nextInt(13) + 1; 
		num_palo = rnd.nextInt(4);
		

		// Asignamos As, Jota, Reina y Rey al valor que tienen en la baraja y lo mostramos por pantalla.

		switch (num_carta) {
		case 1:
			valor_especial = "As";
			System.out.printf("%s", valor_especial);
			break;
		case 11:
			valor_especial = "Jota";
			System.out.printf("%s", valor_especial);
			break;
		case 12:
			valor_especial = "Reina";
			System.out.printf("%s", valor_especial);
			break;
		case 13:
			valor_especial = "Rey";
			System.out.printf("%s", valor_especial);
			break;
		default:
			System.out.printf("%d", num_carta); // El resto de n�meros se muestran tal cual.
		}
		

		// Asignamos a cada palo el n�mero aleatorio entre 0 y 3 y mostramos el palo por pantalla.
		switch (num_palo) {
		case 0:
			palo = "Picas.";
			System.out.printf(" de %s", palo);
			break;
		case 1:
			palo = "Corazones.";
			System.out.printf(" de %s", palo);
			break;
		case 2:
			palo = "Diamantes.";
			System.out.printf(" de %s", palo);
			break;
		case 3:
			palo = "Tr�boles.";
			System.out.printf(" de %s", palo);
			break;
		}

	}

}
