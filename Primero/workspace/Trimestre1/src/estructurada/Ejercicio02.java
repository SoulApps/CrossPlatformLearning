package estructurada;

import java.util.Scanner;

public class Ejercicio02 {

public static void main(String[] args) {
		
		int x, y;

		Scanner teclado = new Scanner(System.in);
		x=teclado.nextInt();
		y=teclado.nextInt();
		
		if(x%y==0)
			System.out.printf("%d es m�ltiplo de %d", x, y);
		else
			System.out.printf("%d no es m�ltiplo de %d", x, y);
		
		teclado.close();
	}

}
