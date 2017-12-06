package HistoriaPack;

import java.util.Scanner;

import ArmasPack.Arco;
import ArmasPack.Espada;
import ArmasPack.Martillo;
import ArmasPack.Varita;
import ClasePack.Arquero;
import ClasePack.Caballero;
import ClasePack.Mago;
import ClasePack.Paladin;

public class Historia {

	public static void pausaDramatica (int n){
		
		try {
			Thread.sleep(n);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		int r = 0, n;
		Scanner teclado = new Scanner (System.in);
		
		//Creamos las clases.
		
		Mago mago = new Mago();
		Arquero arquero = new Arquero();
		Paladin paladin = new Paladin();
		Caballero caballero = new Caballero();
		
		//Creamos los personajes que estarán en la Arena.
		
		Personaje pj = new Personaje ("Slash", paladin);
		Personaje pj2 = new Personaje ("Antonio", arquero);
		Personaje pj3 = new Personaje ("Jose", caballero);
		Personaje pj4 = new Personaje ("Merlin", mago);
		
		//Creamos las armas.
		
		Arco arco = new Arco ("Arco largo de Gladiador belicista", false, true, 20);
		Espada espada = new Espada ("Filo de calamidad", false, false, 35);
		Martillo martillo = new Martillo ("Mano de Plata", true, false, 13);
		Varita varita = new Varita ("Varita de pico vil de impostor", true, true, 15);
		
		//Creamos los hilos.
		
		Combate c = new Combate (pj, pj2, pj3, pj4);
		Combate c2 = new Combate (pj2, pj, pj3, pj4);
		Combate c3 = new Combate (pj3, pj, pj2, pj4);
		Combate c4 = new Combate (pj4, pj, pj2, pj3);
		
		//Comienza la historia.
		
		System.out.println("Erase una vez un reino donde todo era felicidad, su gente,\n"
					     + "su rey, su reina, su princesa, todos gozaban con la tranquilidad\n"
					     + "y la paz que cubria todo su territorio. Pero esa paz duro poco,\n"
					     + "cuando el mago Merlin aparecio se fue algo muy querido por el pueblo\n"
					     + "y lo que daba esa felicidad tan inmensa, la CERVEZA.\n");
		
		pausaDramatica(7000);
		
		System.out.println("Poco a poco el ese bien tan preciado se iba acabando y nadie sabia que\n"
					     + "o quien estaba acabando con las reservas que tanto con tanto esfuerzo habian\n"
					     + "conseguido.\n");
		
		pausaDramatica(6000);
		
		System.out.println("El rey empezó a investigar y descubrió quiene estaba detras de todo eso,\n"
					     + "sin que se diera cuenta urdió un plan para acabar con Merlín y traer de vuelta\n"
					     + "la felicidad de su pueblo. Pensó en contratar a 3 mercenarios y hacer un torneo\n"
					     + "donde al ganador se le concederia un deseo, ya fuese riquezas, poder, o la mano de\n"
					     + "de su propia hija, la princesa que sabia que era del agrado del joven mago.\n");
		
		pausaDramatica(8000);
		
		System.out.println("Convocó a toda su corte y propuso el torneo, a todos les parecio una magnifica idea\n"
					     + "que cuatro personas se dieran una muerte lenta y dolorosa en un coliseo, un pueblo\n"
					     + "un poco macabro que se le va a hacer. El rey contrato a 3 de los peores mercenarios\n"
					     + "conocidos en todo el reino. Slash, un sádico paladin que habia sido antiguo\n"
					     + "comandante de la guardia real se le conoce por arrancar las cabelleras de sus\n"
					     + "contrincantes despues de matarlos. Antonio, un salvaje mercenario que vive en los\n"
					     + "bosques donde caza a los ricos que pasan desprevenidos para asi darle el dinero\n"
					     + "a los pobres... No, es broma, se lo queda el y se lo gasta en alcohol y furcias.\n"
					     + "Y Jose, Jose no quiere riquezas, Jose no quiere a la princesa, Jose solo odia a\n"
					     + "todo el mundo, sé listo, sé como Jose.\n");
		
		pausaDramatica(12000);
		
		System.out.println("El torneo está a punto de comenzar y cada contrincante se equipa con su mejor arma.\n");
		
		pausaDramatica(3000);
		
		//Armamos a los personajes.
		
		try {
			System.out.println("El Guerrero Jose saca su ''Filo de calamidad'' dispuesto a propagar odio.");
			pj.armar(martillo);
			pausaDramatica(3000);
			System.out.println("Antonio saca su arco robado a un poderoso mago, ¿Que podrá hacer?");
			pj2.armar(arco);
			pausaDramatica(3000);
			System.out.println("Slash lame la empuñadura de su martillo esperando poder darle sangre hoy.");
			pj3.armar(espada);
			pausaDramatica(3000);
			System.out.println("Y merlin se equipa la varita que heredo de su padre.");
			pj4.armar(varita);
			pausaDramatica(3000);
		} catch (ClaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\nEl rey inauguró el torneo diciendo 'Querido pueblo hoy se celebrara\n"
						 + "el primer torneo en nuestro reino, sed bienvenidos Y DISFRUTAD DE LA\n"
						 + "MASACRE (El 19 de febrero en cines).");
		
		pausaDramatica(4000);
		
		//Comienza la pelea.
		
		System.out.println("\n\n-----------------------------------");
		System.out.println("EL TORNEO");
		System.out.println("-----------------------------------\n\n");
		
		c.start();
		c2.start();
		c3.start();
		c4.start();
		
		do{
			if (!c.isAlive()&&!c2.isAlive()&&!c3.isAlive()&&!c4.isAlive()){
					
		
				System.out.println("\nEl torneo ha acabado y el ganador sale entre todo el polvo ocasionado");
				if(pj.getVida()>0){
					System.out.println(pj.getNombre()+" es el ganador. Todos le vitorean y se siente el mejor.\n");
				}
				
				else if(pj2.getVida()>0){
					System.out.println(pj2.getNombre()+" es el ganador. Todos le vitorean y se siente el mejor.\n");
				}
				
				else if(pj3.getVida()>0){
					System.out.println(pj3.getNombre()+" es el ganador. Todos le vitorean y se siente el mejor.\n");
				}
				
				else if(pj4.getVida()>0){
					System.out.println(pj4.getNombre()+" es el ganador. Todos le vitorean y se siente el mejor.\n");
				}
				
				System.out.println("El rey se acerca al ganador y le dice 'Como ganador del torneo ¿Que es lo\n"
								 + "que deseas? ¿Riquezas(1)? ¿Poder(2)? ¿La mano de la princesa(3)? ¿Cerveza(4)?");
				
				n = teclado.nextInt();
				
				switch (n){
				
				case 1:
					System.out.println("\nEl rey te da 3.000.000 monedas de oro y vives entre riquezas toda tu vida.");
					break;
					
				case 2:
					System.out.println("\nEl rey te nombra comandante de su guardia real y te haces un gran guerrero.");
					break;
				
				case 3:
					System.out.println("\nTe casas con la princesa y fabricas decenas de hijos con ella, guiño guiño.");
					break;
					
				case 4:
					System.out.println("\nMatas al rey y te haces con el reino, te conviertes en el nuevo emperador\n"
									 + "del mal y te fornicas a su hija hasta el fin de tu existencia. No sin antes\n"
									 + "sumir el reino en un caos incontrolable.");
					break;
				}
				
				
				r=3;
			}
		} while (r==0);
	}

}
