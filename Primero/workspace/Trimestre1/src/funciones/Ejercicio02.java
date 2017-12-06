package funciones;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		double n1, n2, resultado;
		char operacion;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca un n�mero");
		n1 = teclado.nextInt();
		System.out.println("Introduzca otro n�mero");
		n2 = teclado.nextInt();
		System.out.println("Introduzca la operaci�n");
		operacion = teclado.next().charAt(0);
		teclado.close();

		resultado = calcular(n1, n2, operacion);
		System.out.println(resultado);
	}

	public static double calcular(double n1, double n2, char operacion) {
		double resultado = 0;
		switch(operacion){
		case '+':
			resultado = n1 + n2;
			break;
		case '-':
			resultado = n1 - n2;
			break;
		case '*':
			resultado = n1 * n2;
			break;
		case '/':
			resultado = n1 / n2;
			break;
		}
		return resultado;
		
	}
	
	public static int calcular(int n1, int n2, char operacion) {
		int resultado = 0;
		switch(operacion){
		case '+':
			resultado = n1 + n2;
			break;
		case '-':
			resultado = n1 - n2;
			break;
		case '*':
			resultado = n1 * n2;
			break;
		case '/':
			resultado = n1 / n2;
			break;
		}
		return resultado;
		
	}


}
