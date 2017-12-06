package estructurada;

import java.util.Scanner;


public class Ejercicio20 {

	public static void main(String[] args) {
		
		int n = 1, aux = 1, m;
		Scanner teclado=new Scanner(System.in);
		
		m=teclado.nextInt();
		teclado.close();
		
		while (aux <= m) {
			aux += n;
			System.out.print(n + " ");
			n++;
		}
		
		
	}

}
