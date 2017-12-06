import java.util.Random;
import java.util.Scanner;
public class Examen01AlejandroSanchezGalvin {

	public static void main(String[] args) {
	//DECLARACIÓN DE VARIABLES
		int num_carta=0,palo,dinerojugador1=100,dinerojugador2=100,apuesta=0,palo1,num_carta1=0,palo2=0,num_carta2=0;
		num_carta1=num_carta1+num_carta;
		
		boolean peticion,jugar,jugador;
		
		
		Random rnd = new Random();
		
		Scanner teclado = new Scanner(System.in);
		
	//PEDIMOS LA APUESTA INDICÁNDO LA CANTIDAD MÁXIMA POSIBLE PARA APOSTAR Y CONTROLÁNDOLA
		do {
		
		if (dinerojugador1<=dinerojugador2 || dinerojugador1<=1); 	
		System.out.printf("Introduzca la cantidad de su apuesta, ahora pueden apostar hasta %d euros.%n",dinerojugador1/2);
		apuesta=teclado.nextInt();
		
		if (dinerojugador1>=dinerojugador2 || dinerojugador2<=1); 	
		System.out.printf("Introduzca la cantidad de su apuesta, ahora pueden apostar hasta %d euros.%n",dinerojugador2/2);
		apuesta=teclado.nextInt();
		
		System.out.println("Turno del jugador 1");
	//SE REPARTEN DOS CARTAS ALEATORIAS
		do{		
		num_carta=rnd.nextInt(13)+1;
			if(num_carta>1 && num_carta<=10)
				System.out.printf("%d ",num_carta);
			if (num_carta==1)
				System.out.printf("As ");
			if (num_carta==11)
				System.out.printf("Jota ");
			if (num_carta==12)
				System.out.printf("Reina ");
			if (num_carta==13)
				System.out.printf("Rey ");
			palo=rnd.nextInt(4)+1;
			if (palo==1)
				System.out.println("de picas");
			if (palo==2)
				System.out.println("de diamantes");
			if (palo==3)
				System.out.println("de tréboles");
			if (palo==4)
				System.out.println("de corazones");
		}
		while (num_carta<=0);
		
		do{		
			num_carta2=rnd.nextInt(13)+1;
				if(num_carta2>1 && num_carta2<=10)
					System.out.printf("%d ",num_carta2);
				if (num_carta2==1)
					System.out.printf("As ");
				if (num_carta2==11)
					System.out.printf("Jota ");
				if (num_carta2==12)
					System.out.printf("Reina ");
				if (num_carta2==13)
					System.out.printf("Rey ");
				palo2=rnd.nextInt(4)+1;
				if (palo2==1)
					System.out.println("de picas");
				if (palo2==2)
					System.out.println("de diamantes");
				if (palo2==3)
					System.out.println("de tréboles");
				if (palo2==4)
					System.out.println("de corazones");
			}
			while (num_carta<=0);
		
		
	//SE COMPRUEBAN LOS RESULTADOS Y PREGUNTA SI QUIERE OTRA CARTA
		
		System.out.printf("%d",num_carta1);
		System.out.println("¿Quiere otra carta?");
		peticion=teclado.nextBoolean();
		do{		
			num_carta2=rnd.nextInt(13)+1;
				if(num_carta2>1 && num_carta2<=10)
					System.out.printf("%d ",num_carta2);
				if (num_carta2==1)
					System.out.printf("As ");
				if (num_carta2==11)
					System.out.printf("Jota ");
				if (num_carta2==12)
					System.out.printf("Reina ");
				if (num_carta2==13)
					System.out.printf("Rey ");
				palo2=rnd.nextInt(4)+1;
				if (palo2==1)
					System.out.println("de picas");
				if (palo2==2)
					System.out.println("de diamantes");
				if (palo2==3)
					System.out.println("de tréboles");
				if (palo2==4)
					System.out.println("de corazones");
		System.out.println("¿Quiere otra carta?");
		peticion=teclado.nextBoolean();}
		while (peticion=true);
		if (peticion=false);
		System.out.println("Se ha plantado, turno del jugador 2");
		
		//SE REPARTEN DOS CARTAS ALEATORIAS
				do{		
				num_carta=rnd.nextInt(13)+1;
					if(num_carta>1 && num_carta<=10)
						System.out.printf("%d ",num_carta);
					if (num_carta==1)
						System.out.printf("As ");
					if (num_carta==11)
						System.out.printf("Jota ");
					if (num_carta==12)
						System.out.printf("Reina ");
					if (num_carta==13)
						System.out.printf("Rey ");
					palo=rnd.nextInt(4)+1;
					if (palo==1)
						System.out.println("de picas");
					if (palo==2)
						System.out.println("de diamantes");
					if (palo==3)
						System.out.println("de tréboles");
					if (palo==4)
						System.out.println("de corazones");
				}
				while (num_carta<=0);
				
				do{		
					num_carta2=rnd.nextInt(13)+1;
						if(num_carta2>1 && num_carta2<=10)
							System.out.printf("%d ",num_carta2);
						if (num_carta2==1)
							System.out.printf("As ");
						if (num_carta2==11)
							System.out.printf("Jota ");
						if (num_carta2==12)
							System.out.printf("Reina ");
						if (num_carta2==13)
							System.out.printf("Rey ");
						palo2=rnd.nextInt(4)+1;
						if (palo2==1)
							System.out.println("de picas");
						if (palo2==2)
							System.out.println("de diamantes");
						if (palo2==3)
							System.out.println("de tréboles");
						if (palo2==4)
							System.out.println("de corazones");
					}
					while (num_carta<=0);
				
				
			//SE COMPRUEBAN LOS RESULTADOS Y PREGUNTA SI QUIERE OTRA CARTA
				
				System.out.println();
				System.out.println("¿Quiere otra carta?");
				peticion=teclado.nextBoolean();
				do{		
					num_carta2=rnd.nextInt(13)+1;
						if(num_carta2>1 && num_carta2<=10)
							System.out.printf("%d ",num_carta2);
						if (num_carta2==1)
							System.out.printf("As ");
						if (num_carta2==11)
							System.out.printf("Jota ");
						if (num_carta2==12)
							System.out.printf("Reina ");
						if (num_carta2==13)
							System.out.printf("Rey ");
						palo2=rnd.nextInt(4)+1;
						if (palo2==1)
							System.out.println("de picas");
						if (palo2==2)
							System.out.println("de diamantes");
						if (palo2==3)
							System.out.println("de tréboles");
						if (palo2==4)
							System.out.println("de corazones");
				System.out.println("¿Quiere otra carta?");
				peticion=teclado.nextBoolean();}
				while (peticion=true);
				System.out.println("Se ha plantado");
				
	//SE COMPRUEBA EL GANADOR, SE REPARTE LA RECOMPENSA Y PREGUNTAR SI QUIERE SEGUIR JUGANDO
			
				
				
				System.out.printf("Gana el jugador %d, ¿quiere seguir jugando?");
				if (jugador=true)
					System.out.println("Jugador 1 gana");
					
				if (jugador=false)
					System.out.println("Jugador 2 gana");
				jugar=teclado.nextBoolean();}
				
				while (jugar=true);
		

	}

}
