package estructurada;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		int n;

		Scanner teclado = new Scanner(System.in);
		n=teclado.nextInt();
		
		if (n>=1){
			System.out.println("El número es positivo.");
		}
		
		else if (n<=-1){
			System.out.println("El número es negativo");
		}
		
		else 
			System.out.println("El número es cero.");
		
			
		teclado.close();
	}

}
