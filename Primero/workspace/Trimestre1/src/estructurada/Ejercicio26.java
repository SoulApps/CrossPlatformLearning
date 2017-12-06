package estructurada;

public class Ejercicio26 {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";

	public static void main(String[] args) {

		final byte LIMITE = 8;
		int i = 0, j = 0;
		String N = ANSI_BLACK + "█" + ANSI_RESET, B = "█";

		for (i = 1, j = 1; i <= LIMITE; i++) {
			for (j = 0; j < LIMITE; j++) {
				if ((i + j) %2 == 0) {
					System.out.print(N);
				}
				else if ((i + j) %2 != 0) {
					System.out.print(B);
				}
			}
			System.out.println();

		}

	}

}
