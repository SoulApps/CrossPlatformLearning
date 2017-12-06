package estructurada;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {

		final byte NUM_PALOS=4,NUM_CARTAS=13,VALOR_FIGURA=10,VALOR_AS=11,VALOR_21=21;
		final byte JUGADOR1=0,JUGADOR2=1,OPCION_SI=1,OPCION_NO=2;
		final int DINERO_INICIAL=100;
		int dinero1=DINERO_INICIAL,dinero2=DINERO_INICIAL;
		byte apuesta, apuesta_maxima, mano=0,opcion=0;
		byte palo,carta,num_cartas,puntuacion=0,puntuacion1=0,cont_as,jugador;
		String nombre_palo="",nombre_carta="";
		boolean blackjack1 = false,blackjack = false;
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		/*
		 * Jugar varias manos de blackjack entre dos jugadores hasta que uno de
		 * los dos se quede sin dinero(0 ó 1 euro) o decidan salir
		 */
		System.out.println("Bienvenidos al juego de Blackjack");

		do {
			mano++;
			// indicar el número de mano
			System.out.printf("%nEl número de esta mano es: %d", mano);
			// Se establece por ambos jugadores la apuesta: como máximo, la mitad del que menos dinero tenga
			if (dinero1 <= dinero2)
				apuesta_maxima = (byte) (dinero1 / 2);
			else
				apuesta_maxima = (byte) (dinero2 / 2);

			do {// Controlamos que no sea negativo, 0 ó mayor a la apuesta máxima
				System.out.printf("%n¿Cuánto dinero desean apostar? Como máximo: %d%n",apuesta_maxima);
				apuesta = teclado.nextByte();
			} while (apuesta <= 0 || apuesta > apuesta_maxima);

			// Primero juega el jugador1 y luego el jugador2

			for (jugador=0;jugador<2;jugador++) {
				//Inicializamos variables
				blackjack=false;
				puntuacion=0;
				num_cartas=0;
				cont_as=0;
				//Indicamos en qué jugador estamos
				if(jugador==JUGADOR1)
					System.out.println("\nLe toca el turno al jugador1");
				else
					System.out.println("\nLe toca el turno al jugador2");
				do {
					// Repartimos dos cartas aleatorias la primera vez, luego de una en una a petición del jugador
					num_cartas++;
					nombre_carta = "";
					palo = (byte) aleatorio.nextInt(NUM_PALOS);
					carta = (byte) (aleatorio.nextInt(NUM_CARTAS) + 1);
					//carta = teclado.nextByte(); Para probarlo
					switch (palo) {
					case 0:
						nombre_palo = "Picas";
						break;
					case 1:
						nombre_palo = "Tréboles";
						break;
					case 2:
						nombre_palo = "Corazones";
						break;
					case 3:
						nombre_palo = "Diamantes";
						break;
					}
					switch (carta) {
					case 1:
						nombre_carta = "As";
						puntuacion += VALOR_AS;
						cont_as++; 	//Incremento el contador de AS por si se pasa, saber si tiene algún As
						break;
					case 11:
						nombre_carta = "Jota";
						puntuacion += VALOR_FIGURA;
						break;
					case 12:
						nombre_carta = "Reina";
						puntuacion += VALOR_FIGURA;
						break;
					case 13:
						nombre_carta = "Rey";
						puntuacion += VALOR_FIGURA;
						break;
					default:
						nombre_carta += carta;
						puntuacion += carta;
					}
					System.out.printf("%n%s de %s", nombre_carta, nombre_palo);
					//Si se pasa y ha sacado algún AS, el AS se le cuenta como 1
					while (puntuacion > VALOR_21 && cont_as>0){ 
						puntuacion = (byte)(puntuacion - VALOR_AS + 1);
						cont_as--; 
					}
					if (puntuacion == VALOR_21 && num_cartas == 2)
						blackjack = true;
					if(blackjack)
						System.out.println("\n ¡¡¡¡¡ BLACKJACK !!!!!!");
					else if(num_cartas!=1) // Indicamos el total si no estamos en la primera carta
						System.out.printf("%nLlevas %d puntos%n", puntuacion);
					if (num_cartas != 1 && !blackjack && puntuacion < VALOR_21) {
						/* num_cartas !=1: la primera vez se reparten dos cartas seguidas sin preguntarle al jugador
						  !blackjack: Si tiene blackjack no se le piden más cartas
						  puntuacion < VALOR_21: Si se ha pasado no se le piden más cartas*/
						
						do { // Se le pregunta si se planta o si desea otra carta.Controlamos que introduzca 1 ó 2
							System.out.printf("%n¿Desea otra carta?%n\t1.Sí%n\t2.No%n");
							opcion = teclado.nextByte();
						} while (opcion != OPCION_SI && opcion != OPCION_NO);
					} else
						opcion = OPCION_SI;// Para forzar la iteración del bucle y nos reparta la segunda carta
				} while (opcion == OPCION_SI && !blackjack && puntuacion < VALOR_21);
				if(jugador==JUGADOR1){//Se almacena la puntuación y el blackjack del jugador1 para luego poder compararla con el jugador2 
						puntuacion1=puntuacion;
						blackjack1=blackjack;
				}
			} 
			//Comparación de resultados y movimientos de dinero
			if(blackjack1 && !blackjack){	   //Gana el jugador1 con blackjack
				dinero1+=apuesta*2;
				dinero2-=apuesta*2;
				System.out.println("Ha ganado el jugador1 con blackjack");
			}
			else if(!blackjack1 && blackjack){ //Gana el jugador2 con blackjack
				dinero1-=apuesta*2;
				dinero2+=apuesta*2;
				System.out.println("Ha ganado el jugador2 con blackjack");
			}
			else if(puntuacion1 <= VALOR_21 && (puntuacion1>puntuacion || puntuacion>VALOR_21)){ //Gana el jugador1
				dinero1+=apuesta;
				dinero2-=apuesta;
				System.out.println("Ha ganado el jugador1");
			}
			else if(puntuacion <= VALOR_21 && (puntuacion>puntuacion1 || puntuacion1>VALOR_21)){ //Gana el jugador2
				dinero1-=apuesta;
				dinero2+=apuesta;
				System.out.println("Ha ganado el jugador2");
			}
			else
				System.out.println("Empate, no hay movimientos de dinero");
			
			System.out.printf("Dinero jugador1: %d  Dinero jugador2: %d",dinero1,dinero2);

			if (dinero1 <= 1 || dinero2 <= 1)
				System.out.println("\nFin del juego, no hay dinero para apostar");
			else {
				do { // Controlamos que introduzca 1 ó 2
					System.out.printf("%n¿Desean continuar con el juego?%n\t1.Sí%n\t2.No%n");
					opcion = teclado.nextByte();
				} while (opcion != OPCION_SI && opcion != OPCION_NO);
			}

		} while (opcion != OPCION_NO && dinero1 > 1 && dinero2 > 1);
	}
}
