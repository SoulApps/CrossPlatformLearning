package boletin02;

import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		
//Declaración de variables.
		long tiempo_inicio = 0;
		
		Scanner teclado = new Scanner(System.in);
		int respuesta, nFila_alfil, nColum_alfil, fila, columna = 1, i;
		final char ALFIL = 'A', MOVIMIENTO = '*', BLANCO = 'B', NEGRO = 'N';
		final byte DIMENSION = 8; 
		
	//Nos aseguramos de que el programa inicie al menos una vez, y damos opciones al usuario:
		do {
			System.out.println("¿Qué quiere hacer?");
			System.out.println();
			System.out.println("1. Introducir coordenadas.");
			System.out.println("2. Salir del programa.");
			System.out.println();
			System.out.print("Respuesta: ");
			respuesta = teclado.nextInt();
			
			System.out.println();
			
	//Si respuesta = 1:
		//Petición de posición del alfil (coordenadas).
			
		if (respuesta == 1) {
			System.out.println("Introduce las coordenadas correspondientes a la posición del alfil, ");
			System.out.println("(Deben ser mayor que 1 y menor que 8.):");
			
			do {
				System.out.print("- Primera (fila): ");
				nFila_alfil = teclado.nextInt();
				System.out.print("- Segunda (columna): ");
				nColum_alfil = teclado.nextInt();
				System.out.println();
			} while ( nFila_alfil < 1 || nFila_alfil > 8 || nColum_alfil < 1 || nColum_alfil > 8 );
			
			System.out.println();			
			tiempo_inicio = System.nanoTime();
		
		//Bucle para imprimir la "cabecera" del tablero (columnas: C1, C2...)
			System.out.printf("\t ");
			
			for ( i = 1; i <= 8; i++)
				System.out.printf(" C%d ",i);
				
			System.out.println();
		
		//Creamos tablero:
			//Creamos filas con bucle for. En cada fila:
			for (fila = 1; fila <= DIMENSION; fila++){
				
				//Imprimimos el número de filas del tablero ("lateral": F1, F2...)
				System.out.printf("  F%d --> ", fila);
				
				//Imprimimos los 8 carácteres que compondrán las filas. 
				for (columna = 1; columna <= DIMENSION; columna++)
					
					//Especificamos que caracter debe ser impreso evaluando las diferentes posibilidades con if. 
						//imprimimos alfil si se cumple que:
					if (nFila_alfil == fila && nColum_alfil == columna)
						System.out.printf("| %c ",ALFIL);
				
						//Marcamos en el tablero los posibles movimientos del alfil si se cumple que:
					else if ( (fila - columna == nFila_alfil - nColum_alfil) || (fila + columna == nFila_alfil + nColum_alfil) )
						System.out.printf("| %c ",MOVIMIENTO);
						
						//Imprimimos casilla blanca si se cumple que:
					else if( (columna + fila) % 2 == 0)
						System.out.printf("| %c ",BLANCO);
				
						//Imprimimos casilla negra si se cumple que:
					else
						System.out.printf("| %c ",NEGRO);
					
				//Damos formato al tablero. 
				System.out.printf("|");
				System.out.println();
				System.out.printf("\t --------------------------------- \n");
				
			}
			
		}
			
			
			System.out.println();
			System.out.println("###########################################");
			System.out.println();
			
		} while (respuesta != 2);
			
		teclado.close();
	
		System.out.printf("El tiempo de ejecucion es: %d ns",System.nanoTime() - tiempo_inicio);
	}

}
