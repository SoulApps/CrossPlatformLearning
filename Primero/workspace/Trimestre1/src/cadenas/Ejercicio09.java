package cadenas;

import java.util.Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {
		
		int i, n;
		String sPrincipal, sSecundaria, resultado = "";
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la cadena principal");
		sPrincipal = teclado.nextLine();
		System.out.println("Introduzca la cadena secundaria");
		sSecundaria = teclado.nextLine();
		System.out.println("Indique desde qué carácter desea concatenar");
		n = teclado.nextInt();
		teclado.close();

        for (i = n; i <= sSecundaria.length() - 1; i++)
            resultado += sSecundaria.charAt(i);

        System.out.println(sPrincipal + resultado);

	}

}
