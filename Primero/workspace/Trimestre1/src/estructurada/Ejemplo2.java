package estructurada;

import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		final int MAYOR = 18;
		int edad = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca su edad.");
		edad = teclado.nextInt();
		
		if (edad >= MAYOR)
			System.out.println("Es mayor de edad.");
		else if (edad < 0)
			System.out.println("Error, edad menor que 0.");
			
		else
			System.out.println("Es menor de edad.");
		
		teclado.close();

	}

}
