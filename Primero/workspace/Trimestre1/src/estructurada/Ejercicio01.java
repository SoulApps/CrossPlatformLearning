package estructurada;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		int n;

		Scanner teclado = new Scanner(System.in);
		n=teclado.nextInt();
		
		if (n>=1){
			System.out.println("El n�mero es positivo.");
		}
		
		else if (n<=-1){
			System.out.println("El n�mero es negativo");
		}
		
		else 
			System.out.println("El n�mero es cero.");
		
			
		teclado.close();
	}

}
