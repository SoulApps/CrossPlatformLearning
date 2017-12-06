package estructurada;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		
		final byte LIMITE=15;
		int max, min, n, i;
		String mayor="Introduzca el rango superior.";
		String menor="Introduzca el rango inferior.";
		Random rnd=new Random();
		Scanner teclado=new Scanner(System.in);
		
		System.out.println(mayor);
		max=teclado.nextInt();
		System.out.println(menor);
		min=teclado.nextInt();
		teclado.close();
		
		for(i=0;i<LIMITE;i++){
		n = rnd.nextInt((max - min) + 1) + min;
		System.out.println(n);
		}

	}

}
