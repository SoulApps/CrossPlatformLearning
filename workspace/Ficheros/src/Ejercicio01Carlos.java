import java.util.Random;

import Teclado.Teclado;

public class Ejercicio01Carlos {

	/*
	 * a) que la cadena sea exactamente �True�.
	 * b) que la cadena contenga tres letras, may�sculas o min�sculas.
	 * c) que la cadena contenga 5 o m�s caracteres que no sean la �, la z ni la x.
	 * d) que la cadena no empiece con un n�mero.
	 * e) que la cadena tenga un n�mero arbitrario de caracteres excepto la b.
	 * f) que la cadena tenga un n�mero m�s peque�o que 300.
	 * g) que la cadena sea un n�mero de tel�fono.
	 * h) que la cadena sea un DNI.
	 * i) que la cadena sea un nombre, es decir, que no tenga espacios, que no sea una cadena vac�a y que empiece por may�sculas.
	 * j) que la cadena empiece con vocal y luego tenga varias consonantes o ninguna.
	 * k) que la cadena sea un correo electr�nico acabado en .com o en .es.
	 */
	
	public static void main(String[] args) {
		@SuppressWarnings("unused") // Para que no salte el warning de que la variable cadena no se usa nunca
		String cadena;
		Random random=new Random();
		int longitud;

		 // a) que la cadena sea exactamente �True�.
		cadena=Teclado.cadena("Introduzca la palabra True: ", "True");

		 // b) que la cadena contenga tres letras, may�sculas o min�sculas.
		cadena=Teclado.cadena("Introduzca 3 letras: ", "[A-Z�a-z�]{3}");
		cadena=Teclado.cadena("Introduzca 3 letras: ", "[\\w��]{3}");

		 // c) que la cadena contenga 5 o m�s caracteres que no sean la �, la z ni la x.
		cadena=Teclado.cadena("Introduzca 5 caracteres o mas que no sean ni la \"�\", ni la \"z\" ni la \"x\": ", "[^�zx]{5,}");

		 // d) que la cadena no empiece con un n�mero.
		cadena=Teclado.cadena("Introduzca una cadena que no empiece por un numero: ", "[^0-9].*");
		cadena=Teclado.cadena("Introduzca una cadena que no empiece por un numero: ", "[\\D].*");

		 // e) que la cadena tenga un n�mero arbitrario de caracteres excepto la b.
		longitud=random.nextInt(25);
		cadena=Teclado.cadena("Introduzca una cadena de "+longitud+" caracteres de longitud que no contenga la \"b\": ", "[^b]{"+longitud+"}");
		
		 // f) que la cadena tenga un n�mero m�s peque�o que 300.
		cadena=Teclado.cadena("Introduzca un numero mas peque�o que 300: ", "[1-2]?[0-9]?[0-9]");
		cadena=Teclado.cadena("Introduzca un numero mas peque�o que 300: ", "[12]?[0-9]{1,2}");
		
		// g) que la cadena sea un n�mero de tel�fono.
		cadena=Teclado.cadena("Introduzca un numero de telefono: ", "[9876][0-9]{8}");
		
		// h) que la cadena sea un DNI.
		cadena=Teclado.cadena("Introduzca un NIF o DNI: ", "[0-9]{8}[A-Z&&[^IOU]]");
		
		// i) que la cadena sea un nombre, es decir, que no tenga espacios, que no sea una cadena vac�a y que empiece por may�sculas.
		cadena=Teclado.cadena("Introduzca su nombre (solo el primero): ", "[A-Z�][a-z�]+");
		
		// j) que la cadena empiece con vocal y luego tenga varias consonantes o ninguna.
		cadena=Teclado.cadena("Introduzca una cadena que empiece por vocal y siga con alguna o ninguna consonante: ", "[AaEeIiOoUu][A-Z�a-z�&&[^AaEeIiOoUu]]*");
		
		// k) que la cadena sea un correo electr�nico acabado en .com o en .es.
		cadena=Teclado.cadena("Introduzca su correo electronico: ", ".*@[a-zA-Z]*(.com||.es)");
		cadena=Teclado.cadena("Introduzca su correo electronico: ", "[a-z][0-9a-z-_\\.]+@[a-z]+\\.(es||com)");
	}
}