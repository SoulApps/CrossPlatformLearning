package estructurada;

import java.util.Scanner;

public class Ejercicio04 {
	
	public static void main(String[] args) {
		final double DIURNO = 3, NOCTURNO = 4.80, FDIA = 1.20, FNOCHE = 1.80;
		int hora, n, f;
		double total = 0;
		boolean festivo = false, noche = false;

		Scanner teclado = new Scanner(System.in);

		// Hora
		System.out.println("Introduza el n�mero de horas:");
		hora = teclado.nextInt();

		// Noche
		System.out.println("Indique si su horario es diurno con 1 o nocturno con 0 ");
		n = teclado.nextInt();
		if (n == 1) {
			noche = false;
		} else if (n == 0)
			noche = true;

		// Festivo
		System.out.println("Indique si es un d�a festivo con 1 o no con 0");
		f = teclado.nextInt();
		if (f == 1) {
			festivo = true;
		} else if (f == 0)
			festivo = false;

		// C�lculos
		if (festivo == true && noche == true) {
			total = (double) hora * FNOCHE + hora * NOCTURNO;
			System.out.printf("Has ganado %d� hoy", total);
		} else if (festivo == true && !noche) {
			total = (double) hora * FDIA + hora * DIURNO;
			System.out.printf("Has ganado %d� hoy", total);
		} else if (!festivo && noche == true) {
			total = (double) hora * NOCTURNO;
			System.out.printf("Has ganado %d� hoy", total);
		} else if (!festivo && !noche) {
			total = (double) hora * DIURNO;
			System.out.printf("Has ganado %d� hoy", total);
		}

		teclado.close();
	}
}
