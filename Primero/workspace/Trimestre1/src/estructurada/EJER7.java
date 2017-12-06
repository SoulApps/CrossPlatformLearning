package estructurada;

import java.util.Random;
import java.util.Scanner;

public class EJER7 {

	public static void main(String[] args) {
		
		int n = 0;
		char resultado;
		String s;
		Scanner teclado = new Scanner(System.in);
		Random rnd=new Random();
		s = teclado.nextLine();	
		
		
		n = rnd.nextInt(s.length());
		resultado = s.charAt(n);
		n++; //Para que muestre a partir del 1 en consola
		System.out.printf("La letra %c está en la posición %d.", resultado, n);
		
		teclado.close();
	}

}
