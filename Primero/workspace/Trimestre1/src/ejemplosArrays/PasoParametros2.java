package ejemplosArrays;

public class PasoParametros2 {

	public static void main(String[] args) {
		
		int i;
		String cadenaEntradaSalida="Hola ",cadenaEntrada="mundo",cadenaSalida;
		String[] arrayEntrada={"de","ocho","lunes","Manuel","mundo"};
		String[] arrayEntradaSalida={"hola ","adios ","es ","hay ","horas ","Programación"};
		String[] arraySalida;
		
		cadenaEntradaSalida=pasoValor(cadenaEntrada,cadenaEntradaSalida);
		System.out.println(cadenaEntradaSalida);
		
		cadenaSalida=pasoValor();
		System.out.println(cadenaSalida);
		
		pasoReferencia(arrayEntrada,arrayEntradaSalida);
		for(i=0;i<arrayEntradaSalida.length;i++)
			System.out.println(arrayEntradaSalida[i]);
		
		arraySalida=pasoReferencia();
		for(i=0;i<arraySalida.length;i++)
			System.out.println(arraySalida[i]);
		
	}
	
	/* Paso de parámetros por valor: 
	 * 	- Entrada: el valor es necesario para la función
	 * 	- Entrada/Salida: el valor es necesario para la función y además se retorna modificado
	 */
	public static String pasoValor(String entrada,String entradaSalida){
		
		entradaSalida+=entrada; 
		return entradaSalida; 
	}
	// Paso de parámetros por valor de salida: el valor lo crea la función y lo retorna.
	public static String pasoValor(){
		String cadena="Programación";
		return "Esto es "+ cadena;
	}
	/* Paso de parámetros por referencia: 
	 * 	- Entrada: el valor es necesario para la función
	 * 	- Entrada/Salida: el valor es necesario para la función o tiene valores válidos 
	 * 		para quien llama a la función. Este parámetro además se modifica. 
	 */
	public static void pasoReferencia(String[] entrada,String[] entradaSalida){
		
		int i,j;
		for(i=0,j=entrada.length-1;i<entradaSalida.length && j>=0;i++,j--)
			entradaSalida[i]+=entrada[j];
	}
	// Paso de parámetros por referencia de salida: el objeto lo crea la función y lo retorna.
	public static String[] pasoReferencia(){
		String[] arraySalida={"Buenos ","días ","Ana ","estamos ","en ","Programación"};
		return arraySalida; 
	}
}
