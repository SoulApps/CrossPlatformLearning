package funciones;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		boolean resultado;
		int n;
		
		Scanner teclado = new Scanner(System.in);
		
		n = teclado.nextInt();
		teclado.close();
		
		resultado = comprobarPrimos(n);
		if (!resultado)
			System.out.println("Es primo");
		else
			System.out.println("No es primo");
		contarPrimos();

	}

	public static boolean comprobarPrimos(int numero) {
		boolean primo = false;
		int i = 2;
		if (numero == 1)
			primo = false;
		else {
			while (primo == false && i != numero) {	//Empiezo en 2 para que no cuente el 1
				if (numero % i != 0) {
					primo = false;
					i++;
				}
				else
					primo = true;
			}
		}
		return primo;
	}

	public static void contarPrimos() {
		int i;
		for (i = 1; i <= 10000; i++)
			if (!comprobarPrimos(i))
				System.out.println(i);
	}
}
