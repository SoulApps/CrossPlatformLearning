package estructurada;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		
		int x = 0, y = 0, menu = 0, resultado = 0;
		boolean salir=false;
		String mensaje="¿Qué desea hacer?%n1.Sumar%n2.Restar%n3.Multiplicar%n4.Dividir%n5.Salir%n";
		String adios="¡Hasta pronto!";
		String numx="Introduzca el primer valor", numy="Introduzca el segundo valor";
		Scanner teclado=new Scanner(System.in);

		do{
			System.out.printf(mensaje);
			menu=teclado.nextInt();
			
			switch(menu){
				case 1:
					System.out.println(numx);
					x=teclado.nextInt();
					System.out.println(numy);
					y=teclado.nextInt();
					resultado=x+y;
					System.out.println(resultado);
					break;
				case 2:
					System.out.println(numx);
					x=teclado.nextInt();
					System.out.println(numy);
					y=teclado.nextInt();
					resultado=x-y;
					System.out.println(resultado);
					break;
				case 3:
					System.out.println(numx);
					x=teclado.nextInt();
					System.out.println(numy);
					y=teclado.nextInt();
					resultado=x*y;
					System.out.println(resultado);
					break;
				case 4:
					System.out.println(numx);
					x=teclado.nextInt();
					System.out.println(numy);
					y=teclado.nextInt();
					resultado=x/y;
					System.out.println(resultado);
					break;
				case 5:
					System.out.println(adios);
					salir=true;
					break;
			}
		
		} while(!salir);
			
		teclado.close();
		
	}

}
