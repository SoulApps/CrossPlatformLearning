import java.util.InputMismatchException;
import java.util.Scanner;


public class Funciones {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		double oper1=98.45,oper2=4.12,result;
		char operacion='*';
		boolean error=false;
		
		//Llamada a la función con literales
		System.out.println(calculadoraDecimal(23.65,45.78,'+'));
		//Llamada a la función con variables



		result=calculadoraDecimal(oper1,oper2,operacion);
		calculadoraDecimal(operando1 = oper1, operando2 = oper2, operacion = operacion);
										1					2					+






		System.out.printf("El resultado de %c %.2f y %.2f es %.2f",operacion,oper1,oper2,result);
		//Llamada a la función con datos introducidos por el usuario
		do {
			try {
				System.out.println("\nIntroduzca un número decimal: ");
				oper1 = teclado.nextDouble();
				System.out.println("Introduzca otro número decimal: ");
				oper2 = teclado.nextDouble();
				do {
					System.out.printf("Introduzca una operación: +,-,*,/ ");
					operacion = teclado.next().charAt(0);
				} while (operacion!='+' && operacion!='-' && operacion!='*' && operacion!='/');
				result = calculadoraDecimal(oper1, oper2, operacion);
				System.out.printf("El resultado de %c de %.2f y %.2f es %.2f",operacion, oper1, oper2, result);
				error=false;
			} catch (InputMismatchException e) {
				System.out.println("Error, no ha introducido un número decimal");
				error=true;
				teclado.nextLine(); //Se limpia el buffer
			}
		} while (error);

		teclado.close();		

	}
	/*Definición de la función:
	 * Tipo devuelto por la función: void(si no devuelve nada), int, double,etc
	 *    	  Se devuelve con un return. Si es void, no tiene return. 
	 * Nombre de la función: la misma regla de escritura que los identificadores de 
	 * 	  variables y en minúscula. Si son varias palabras, la primera letra de la
	 * 	  palabra en mayúscula, excepto la primera palabra que siempre va en minúscula.
	 *        Ej: imprimirResultadoDecimal 
	 * Parámetros o argumentos de entrada a la función dentro del paréntesis con sus tipos. 
	*/
	public static double calculadoraDecimal(double operando1,double operando2,char operacion){
		double resultado=0;
		
		switch(operacion){
		case '+': 
			resultado=operando1+operando2;
			break;
		case '-':
			resultado=operando1-operando2;
			break;
		case '*':
			resultado=operando1*operando2;
			break;
		case '/':
			resultado=operando1/operando2;
			break;
		}
		return resultado;
	}

}
