package examen;
import static examen.Colores.*;

import java.util.Random;
import java.util.Scanner;
public class DibujoLetras {
	/*
	 * 1. Petición de una palabra al usuario de hasta 20 caracteres
	 * 2. Elección aleatoria de los colores: 
	 * 		-  Normal
	 * 		-  Rojo-verde
	 * 		-  Azul-amarillo
	 * 3. Realizar un bucle para recorrer cada una de las líneas, que se ejecute tantas veces como la longitud de la palabra
	 * 		3.1 Si es la primera línea, escribir todos los caracteres de la cadena
	 * 		3.2 Si es la última línea, escribir todos los caracteres de la cadena al revés
	 * 		3.3 Si es cualquier línea excepto la primera y la última, realizar un bucle que se ejecute tantas veces como la longitud de la cadena: 
	 * 			3.3.1 Si es el primer carácter: escribir el carácter de la cadena correspondiente al número de línea. Ej: en la línea 2, escribir el segundo carácter de la cadena 
	 * 			3.3.2 Si es el último carácter: escribir el carácter de la cadena empezando por el final correspondiente al número de línea. Ej: en la línea 2, escribir el segundo carácter de la cadena empezando por el final, es decir, el penúltimo
	 * 			3.3.3 Si es cualquier carácter excepto el primero o el último: escribir un espacio
	  */

	public static void main(String[] args) {
		
		final String AZUL_AMARILLO = "\u001B[33;44m"; //Fondo azul(44) y texto amarillo(33)
		final String AMARILLO_AZUL = "\u001B[43;34m"; //Fondo amarillo(43) y texto azul(34)
		int linea,i,colorAleatorio,longitudPalabra;
		String palabra;
		EnumColor color=EnumColor.NORMAL;
		Scanner teclado=new Scanner(System.in);
		Random aleatorio=new Random();
		//1. Petición de una palabra al usuario de hasta 20 caracteres
		do{
			System.out.print("Introduzca una palabra de hasta 20 caracteres como máximo que no contenga espacios: ");
			palabra=teclado.next();
			if(palabra.length()>20)
				System.out.println("La palabra contiene más de 20 caracteres");			
		}while(palabra.length()>20);
		teclado.close();
		longitudPalabra=palabra.length();
		/*2. Elección aleatoria de los colores: 
			  		-  Normal
			  		-  Rojo-verde
			  		-  Azul-amarillo
			 */
		colorAleatorio=aleatorio.nextInt(3);
		switch(colorAleatorio){
			case 0: 
				color=EnumColor.NORMAL;
				break;
			case 1:
				color=EnumColor.ROJOVERDE;
				break;
			case 2: 
				color=EnumColor.AZULAMARILLO;
				break; 
		}
		//3. Realizar un bucle para que recorra cada una de las líneas, que se ejecute tantas veces como la longitud de la palabra
		for(linea=1;linea<=longitudPalabra;linea++)
			if(linea==1) 			//3.1 Si es la primera línea, escribir todos los caracteres de la cadena
				switch(color){
					case NORMAL:
						System.out.println(palabra);
						break;
					case ROJOVERDE:
						System.out.println(ROJO+palabra+RESET);
						break;
					case AZULAMARILLO:
						System.out.println(AZUL_AMARILLO+palabra+RESET);
						break;
				}
			else if(linea==longitudPalabra){	//3.2 Si es la última línea, escribir todos los caracteres de la cadena al revés
				for(i=longitudPalabra-1;i>=0;i--)
					switch(color){
						case NORMAL:
							System.out.print(palabra.charAt(i));
							break;
						case ROJOVERDE:
							System.out.print(ROJO+palabra.charAt(i)+RESET);
							break;
						case AZULAMARILLO:
							System.out.print(AZUL_AMARILLO+palabra.charAt(i)+RESET);
							break;
					}
				System.out.printf("%n");
			}
			else{   //3.3 Si es cualquier línea excepto la primera y la última, realizar un bucle que se ejecute tantas veces como la longitud de la cadena
				for(i=0;i<longitudPalabra;i++)
					if(i==0)  //3.3.1 Si es el primer carácter: escribir el carácter de la cadena correspondiente al número de línea. Ej: en la línea 2, escribir el segundo carácter de la cadena
						switch(color){
							case NORMAL:
								System.out.print(palabra.charAt(linea-1));
								break;
							case ROJOVERDE:
								System.out.print(VERDE+palabra.charAt(linea-1)+RESET);
								break;
							case AZULAMARILLO:
								System.out.print(AMARILLO_AZUL+palabra.charAt(linea-1)+RESET);
								break;
						}
					else if(i==longitudPalabra-1) //3.3.2 Si es el último carácter: escribir el carácter de la cadena empezando por el final correspondiente al número de línea. Ej: en la línea 2, escribir el segundo carácter de la cadena empezando por el final, es decir, el penúltimo
						switch(color){
							case NORMAL:
								System.out.print(palabra.charAt(longitudPalabra-linea));
								break;
							case ROJOVERDE:
								System.out.print(VERDE+palabra.charAt(longitudPalabra-linea)+RESET);
								break;
							case AZULAMARILLO:
								System.out.print(AMARILLO_AZUL+palabra.charAt(longitudPalabra-linea)+RESET);
								break;
						}	
					else  //3.3.3 Si es cualquier carácter excepto el primero o el último: escribir un espacio
						System.out.printf("%c",' ');
				System.out.printf("%n");
			}
	}
}
