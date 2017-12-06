package cadenas;

import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {

		int i, n;
		String sPrincipal, sSecundaria, resultado = "", aux = "";
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la cadena principal");
		sPrincipal = teclado.nextLine();
		System.out.println("Introduzca la cadena secundaria");
		sSecundaria = teclado.nextLine();
		System.out.println("Introduzca el número de caracteres para concatenar");
		n = teclado.nextInt();
		teclado.close();
		
		for (i = 0; i < n; i++)
			resultado += sSecundaria.charAt(i);

		sPrincipal += resultado;
        System.out.println(sPrincipal);


    }

}
