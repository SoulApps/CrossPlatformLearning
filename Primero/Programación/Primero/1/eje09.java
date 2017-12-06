import java.util.InputMismatchException;
import java.util.Scanner;

//PLANTEAMIENTO:
//1- Pido dos numeros al usuario
//2- Realizamos una funcion que compruebe el MCD entre ambos
//		2.1- La funcion ira obteniendo el resto entre el primer parametro y el segundo parametro,
//			 teniendo en cuenta que una vez obtenido, este resto pasara a ocupar el valor del primer parametro.
//		2.2- Si el resto llega a 0, el cociente entre el primer y segundo parametro sera el MCD.
//3- Imprimimos el resultado
//4- Repetimos el programa tantas veces como diga el usuario

public class Eje09 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x;
		int y;
		boolean salida=false;
		String salir;
		do {
			//Pedimos numeros controlando que solo sean numeros lo que se introduce
			try {

				System.out.println("Introduce primer numero:");
				x = scanner.nextInt();
				System.out.println("Introduce segundo numero:");
				y = scanner.nextInt();

				//Imprimimos el resultado de la funcion directamente
				System.out.println("\n\nMCD: "+mcd(x, y)+"\n\n");

				//Controlamos la salida del usuario
				System.out.println("Pulsa 1 para salir. Cualquier otra cosa para seguir:"); 
				salir = scanner.next();
				if(salir.equals("1"))
					salida=true;
				
			} catch (InputMismatchException e) {
				System.out.println("Error, debe introducirse un numero");
				scanner.nextLine(); //Limpiamos el scanner
			}
		} while (!salida);
		
		System.out.println("Fin del Prorgrama");
		scanner.close();
	}

	//Funcion que calcula el MCD
	private static int mcd(int x, int y) {
		int result;
		
		//si el segundo parametro vale 0 la funcion vale x
		if(y==0)
			result=x;
		else
		//el segundo parametro ocupa el lugar del primero y
		//vamos obteniendo el resto entre el primer y segundo parametro
			result=mcd(y,x%y);
				
		return result;
	}

}