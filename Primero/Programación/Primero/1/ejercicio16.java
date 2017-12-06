package boletinCondicionales;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		Scanner tecl=new Scanner(System.in);
		int i,n,x,absoluto_n;
		double res=1;
		
		//1. Solicitar 2 numeros enteros
		System.out.println("Introduce el numero");
		x=tecl.nextInt();
		System.out.println("Introduce el exponente");
		n=tecl.nextInt();
		tecl.close();
		
		//Asignamos el valor absoluto de n aqui para que el programa solo lo calcule 1 vez
		absoluto_n=Math.abs(n);
		
		//3. Calcular el resultado dependiendo del exponente n
		//si el valor absoluto de n es mayor que 0 hacemos un bucle de n veces donde se calcula el resultado
		for(i=0;i<absoluto_n;i++)res*=x;
		
		//2. Comprobar si el exponente es negativo o positivo y 0
		//4. Mostramos el resultado dependiendo de si el exponente es negativo
		if (n<0) {
			res=1/res;	
			System.out.printf("%d elevado a %d da %f",x,n,res);
		}
		else
			System.out.printf("%d elevado a %d da %.0f",x,n,res);
	}

}
