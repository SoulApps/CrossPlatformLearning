package ejemplosArrays;

public class PasoParametros {

	public static void main(String[] args) {
		
		/*	Paso de parámetros por valor: tipos primitivos y cadenas
		    Paso de parámetros por referencia: objetos, por ejemplo, arrays */
		
		int numero_main=7,i;
		String cadena_main="Soy la cadena del main";
		int array_main[]={0,1,2,3,4,5,6,7,8,9,10};
		
		//Ejemplo de paso por valor con un entero
		paso_valor(numero_main);
		System.out.printf("%nEl número del main: %d",numero_main);
		//Ejemplo de paso por valor con una cadena
		paso_valor(cadena_main);
		System.out.printf("%nLa cadena del main: %s",cadena_main);
		//Ejemplo de paso por referencia con un array de enteros
		for(i=0;i<array_main.length;i++)
			if(i==0)
				System.out.printf("%nElementos del array del main antes de llamar a la función: %d",array_main[i]);
			else
				System.out.printf(", %d ",array_main[i]);
		paso_referencia(array_main);
		for(i=0;i<array_main.length;i++)
			if(i==0)
				System.out.printf("%nElementos del array del main después de llamar a la función: %d",array_main[i]);
			else
				System.out.printf(", %d ",array_main[i]);
		
	}
	public static void paso_valor(int numero_funcion){
		numero_funcion++;
		System.out.printf("El número de la función: %d",numero_funcion);
	}
	public static void paso_valor(String cadena_funcion){
		cadena_funcion+=" y soy la cadena de la función";
		System.out.printf("%nLa cadena de la función: %s",cadena_funcion);
	}
	public static void paso_referencia(int array_funcion[]){
		int i;
		for(i=0;i<array_funcion.length;i++){
			array_funcion[i]+=10;
			if(i==0)
				System.out.printf("%nElementos del array de la función: %d",array_funcion[i]);
			else
				System.out.printf(", %d ",array_funcion[i]);
		}		
	}
}
