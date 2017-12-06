package estructurada;

import java.util.Scanner;

public class Ejemplo4 {

	public static void main(String[] args) {
		
		int nota;
		Scanner teclado = new Scanner(System.in);
		
		nota = teclado.nextInt();
		switch (nota) {
		case 0:
		case 1:
		case 2:
			System.out.println("Deficiente");
			break;
		case 3:
		case 4:
			System.out.println("Insuficiente");
			break;
		case 5:
			System.out.println("Suficiente");
			break;
		case 6:
			System.out.println("Bien");
			break;
		case 7:
		case 8:
			System.out.println("Notable");
			break;
		case 9:
		case 10:
			System.out.println("Sobresaliente");
		}
		
		teclado.close();
	}

}
