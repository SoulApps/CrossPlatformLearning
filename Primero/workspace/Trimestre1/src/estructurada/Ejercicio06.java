package estructurada;

import java.util.Random;

public class Ejercicio06 {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {

		int palo = 0, carta = 0;
		String mensaje = " ", figura = " ";
		Random rnd = new Random();
		String p = " ";

		carta = rnd.nextInt(13) + 1;
		palo = rnd.nextInt(4) + 1;

		switch (palo) {
		case 1:
			if (palo == 1)
				mensaje = "de picas";
			p = ANSI_BLACK + "♠" + ANSI_RESET;
			break;
		case 2:
			if (palo == 2)
				mensaje = "de corazones";
			p = ANSI_RED + "♥" + ANSI_RESET;
			break;
		case 3:
			if (palo == 3)
				mensaje = "de diamantes";
			p = ANSI_BLUE + "♦" + ANSI_RESET;
			break;
		case 4:
			if (palo == 4)
				mensaje = "de tréboles";
			p = ANSI_GREEN + "♣" + ANSI_RESET;
			break;

		}

		switch (carta) {
			case 1:
				if (carta == 1)
					figura = "As";
				break;
			case 11:
				if (carta == 11)
					figura = "Jota";
				break;
			case 12:
				if (carta == 12)
					figura = "Reina";
				break;
			case 13:
				if (carta == 13)
					figura = "Rey";
				break;
		}

		if (carta > 10 || carta == 1)
			System.out.printf("%s %s %s", figura, mensaje, p);
		else
			System.out.printf("%d %s %s", carta, mensaje, p);

	}

}
