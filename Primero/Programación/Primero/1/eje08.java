import java.util.Scanner;


public class Eje08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x; 
		int y; 
		int suma=0; 
		int cont; 
		
		
		
		//Introducimos los numeros controlando que sean positivos
		do {
			System.out.println("Introduce primer numero:");
			x = scanner.nextInt();
			
			System.out.println("Introduce segundo numero:");
			y = scanner.nextInt();
			System.out.println("________________________________________");
			
			if(x<0 || y<0)
				System.out.println("ERROR. Uno de los numeros es negativo.");
		} while (x<0 || y<0);
		
		
		

		//Si ninguno es 0, vamos sumando los numeros el numero de veces que dicta el segundo numero
		for(cont=0 ; cont<y ; cont++)
			suma = suma + x;
		
		
		
		
		//Imprimimos el resultado
		System.out.println();
		System.out.println("            RESULTADO: "+suma);
		System.out.println("________________________________________");
		
		
		scanner.close();
	}

}
