package estructurada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		
		int x = 0, y = 0, z = 0;
		boolean error=false;
		String mensaje="Introduzca tres número positivos.";
		String mensajeError="¡Error, los números deben ser positivos!";
		Scanner teclado=new Scanner (System.in);

		do{
			
			try{
				x=teclado.nextInt();
				y=teclado.nextInt();
				z=teclado.nextInt();
				
				if(x<0 || y<0 || z<0)
					System.out.println(mensajeError);
					error=true;
					
			}catch(InputMismatchException e){
				System.out.println(mensaje);
				error=true;
			}
		} while(!error);
		
		if(x==y && y==z)
			System.out.printf("¡Hay 3 números iguales a %d!", x);
		else if(x==y)
			System.out.printf("¡Hay 2 números iguales a %d!", x);
		else if(y==z)
			System.out.printf("¡Hay 2 números iguales a %d!", y);
		else if(x==z)
			System.out.printf("¡Hay 2 números iguales a %d!", x);
		else
			System.out.println("¡No hay números iguales!");
		
		teclado.close();
	}

}
