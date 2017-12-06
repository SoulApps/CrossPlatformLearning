package estructurada;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		
		int a = 1, b = 2, aux = 0, m;
		Scanner teclado=new Scanner(System.in);
		
		m=teclado.nextInt();
		teclado.close();
		System.out.print("1 1 ");
		
		while (b <= m) {
			System.out.printf("%d ", b);
			aux = b;
			b = b + a;
			a = aux;
		}
		
	}

}
