package estructurada;

import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		final int MAX = 1000;
		double n = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un número");
		n=teclado.nextInt();
		if(n > MAX) {
			n *=  0.15;
			System.out.println(n);
		}
		else 
			System.out.println("El número es menor o igual que 1000");
		
		teclado.close();

	}

}
