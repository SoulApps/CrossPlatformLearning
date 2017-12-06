package estructurada;

import java.util.Scanner;

public class Ejercicio31 {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	
	public static void main(String[] args) {

		/** DECLARACION DR VARIABLES Y OBJETOS */
		Scanner teclado = new Scanner(System.in);
		int fila, columna, filaAlfil, columnaAlfil, repetir;
		boolean continuar=false;
		final String FONDO_MORADO = "\u001B[45m";
		final String FONDO_BLANCO = "\u001B[47m";
		final String CELESTE = "\u001B[36m";
		final String RESET = "\u001B[0m";
		final String ESPACIO = " ";
		final String ASTERISCO = "*";
		final char ALFIL='♝';

		do {
			/** PEDIMOS DATOS */
			do {
				System.out.print("Introduce unas coordenadas para el arfil y mostraremos los movimientos posibles.\nIntroduce la columna: ");
				columnaAlfil = teclado.nextInt();
				if (columnaAlfil < 1 || columnaAlfil > 8)
					System.out.println("¡Error!");
			} while (columnaAlfil < 1 || columnaAlfil > 8);
			do {
				System.out.print("Introduce la fila: ");
				filaAlfil = teclado.nextInt();
				if (filaAlfil < 1 || filaAlfil > 8)
					System.out.println("¡Error!");
			} while (filaAlfil < 1 || filaAlfil > 8);
			
			/** FORMAMOS EL TABLERO */
			
			//IMPRIMIMOS LETRAS DEL TABLERO
			System.out.println("\n\n    a b c d e f g h");
			
			/** FORMAMOS FILA */
			for (fila = 1; fila <= 8; fila++) {
				System.out.println("");
				
				// IMPRIMIMOS NÚMEROS DEL TABLERO (FILA)
				System.out.print(fila+ESPACIO+ESPACIO);

				/** FORMAMOS COLUMNA*/
				for (columna = 1; columna <= 8; columna++) {

					/** OPCIONES DE IMPRESION */
					// ALFIL
					if ((fila == filaAlfil) && (columna == columnaAlfil)){
						if ((columna + fila) % 2 == 0)
							System.out.printf("%s",FONDO_BLANCO+CELESTE+ALFIL+ESPACIO+RESET);
						else
							System.out.print(FONDO_MORADO+CELESTE+ALFIL+ESPACIO+RESET);
					}
					// ASTERISCO
					else if (fila - columna == filaAlfil - columnaAlfil || fila + columna == columnaAlfil + filaAlfil){
						if ((columna + fila) % 2 == 0)
							System.out.print(FONDO_BLANCO+CELESTE+ASTERISCO+ESPACIO+RESET);
						else
							System.out.print(FONDO_MORADO+CELESTE+ASTERISCO+ESPACIO+RESET);
					}
					// BLANCA
					else if ((columna + fila) % 2 == 0)
						System.out.print(FONDO_BLANCO+ESPACIO+ESPACIO+RESET);

					// NEGRA
					else
						System.out.print(FONDO_MORADO+ESPACIO+ESPACIO+RESET);

				}
				
				// IMPRIMIMOS NÚMEROS DEL TABLERO
				System.out.print(ESPACIO+ESPACIO+fila);
			}
			
			//IMPRIMIMOS LETRAS DEL TABLERO
			System.out.println("\n\n    a b c d e f g h");
			

			/** PREGUNTAMOS SI QUIERE VOLVER A DAR POSICION AL ALFIL */
			do {
				System.out.println("\n\n¿Otra vez? (1 para SI / 2 para NO) ");
				repetir = teclado.nextInt();
				if ((repetir != 1) && (repetir != 2))
					System.out.println("¡ERROR!");
			} while ((repetir != 1) && (repetir != 2));
			continuar=(repetir==1)?true:false;
			
		} while (continuar);
		
		teclado.close();
	}

}
