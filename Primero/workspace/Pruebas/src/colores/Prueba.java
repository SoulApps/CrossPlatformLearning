package colores;

public class Prueba {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	
	public static void main(String[] args) {

		System.out.println(ANSI_RED + "ROJO" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "AZUL");
		System.out.println("TODAV�A AZUL"+ANSI_RESET); //Este a veces no se cambia bien.
		System.out.println(ANSI_CYAN+"CIAN");
		
		/* No hace falta hacer reset para cambiar de color pero creo que es recomendable,
		 * ya que en las damas creo recordar que se mezclaron los colores. */
		System.out.println(ANSI_PURPLE+"EL NINJA P�RPURA"+ANSI_RESET);
		
		
		System.out.println(ANSI_YELLOW); //No hace falta ponerlo en cada salida, el color se mantendr�.
		System.out.println("EL NINJA OCRE");
		System.out.println("NO ES CHUCK NORRIS");
		System.out.println(ANSI_RESET); //No hace falta resetearlo en la l�nea.
		
		System.out.println("NORMAL");
		
	}

}
