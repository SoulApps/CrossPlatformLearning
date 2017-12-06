package boletin2;

import java.util.Scanner;

public class Ejer19 {

	public static void main(String[] args) {
		//declaracion de variables
		Scanner teclado = new Scanner(System.in);
		int num, cociente, resto=0, answer=0;
		//comienzo del programa
			//peticion del numero quitando las excepciones
		do {
			System.out.println("Introducir el numero para invertir");
			num=teclado.nextInt();
		} while (0>num);
		cociente=num;
			//divisiones para extraer cada digito
		while (cociente!=0) {
			resto=cociente%10;
			cociente=cociente/10;
			//multiplicacion por 10 para poder construir el numero
			answer=answer*10+resto;
		}
			//impresion en terminal del resultado
		System.out.printf("El numero %d es invertido %d",num,answer);
		teclado.close();
	}

}
