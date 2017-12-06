package estructurada;

import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		
		int num, i, resultado;
		String mensaje="Introduzca un n�mero del 1 al 10";
		Scanner teclado=new Scanner(System.in);
	
		do{
			System.out.println(mensaje);
			num=teclado.nextInt();
		} while(num<0 || num>10);
				
		for(i=0;i<=10;i++){
			resultado=num*i;
			System.out.println(resultado);
		}
		
		
		
		
		teclado.close();
	}
}
