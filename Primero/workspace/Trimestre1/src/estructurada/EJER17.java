package estructurada;

import java.util.Scanner;

public class EJER17 {

	public static void main(String[] args) {
		
		int i, j;
		Scanner teclado = new Scanner(System.in);
		
		for (i = teclado.nextInt(), j = teclado.nextInt(); i < j; i*=2, j /= 2) //*4 para incrementar el límite
			System.out.printf("i = %-5dj = %d\n",i, j);

		//Incluyendo que a>b
		
		/*for (i = teclado.nextInt(), j = teclado.nextInt(); i < j * 4; i*=2, j /= 2) //*4 para incrementar el límite
			System.out.printf("i = %-5dj = %d\n",i, j);
		 */
		teclado.close();
	}

}
