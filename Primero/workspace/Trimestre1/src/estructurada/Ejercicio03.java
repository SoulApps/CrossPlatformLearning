package estructurada;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		final double PRECIO=0.35, DESCUENTO=1.30;
		final int MAXKM=1000;
		int dia, km;
		double resultado;
		
		Scanner teclado=new Scanner(System.in);
		dia=teclado.nextInt();
		km=teclado.nextInt();
		
		if(dia>=7&&km>=MAXKM){
			resultado=PRECIO*km/DESCUENTO;
			System.out.printf("Su viaje cuesta %.2f €", resultado);
		}
		
		else
			resultado=PRECIO*km;
			System.out.printf("Su viaje cuesta %.2f €", resultado);
		
		teclado.close();
	}

}
