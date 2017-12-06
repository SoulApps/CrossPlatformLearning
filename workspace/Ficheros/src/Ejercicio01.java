/**
 * Realizar las siguientes comprobaciones en la entrada de datos utilizando
 * matches.
 **/

public class Ejercicio01 {

	public static void main(String[] args) {

		// DECLARAMOS VARIABLES
		String cadA = "True", cadB = "��B", cadC = "sssss", cadD = "mm9a", cadE = "fooop", cadF = "300", cadG = "956760976";
		String cadH = "12345678F", cadI = "Julio", cadJ = "avv",  cadK="eclipse-lunar@gmail.com";

		// APARTADOS
		// Que la cadena sea exactamente �True�.
		System.out
				.print("A) Que la cadena sea exactamente \"True\". Por ejemplo: "
						+ cadA);
		if (cadA.matches("True"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena contenga tres letras, may�sculas o min�sculas.
		System.out
				.print("B) Que la cadena contenga tres letras, may�sculas o min�sculas. Por ejemplo: "
						+ cadB);
		if (cadB.matches("[a-zA-Z��]{3}"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena contenga 5 o m�s caracteres que no sean la �, la z ni
		// la x.
		System.out
				.print("C) Que la cadena contenga 5 o m�s caracteres que no sean la �, la z ni la x. Por ejemplo: "
						+ cadC);
		if (cadC.matches("[^�xz�XZ]{5,}"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena no empiece con un n�mero.
		System.out
				.print("D) Que la cadena no empiece con un n�mero. Por ejemplo: "
						+ cadD);
		if (cadD.matches("[^0-9].*"))//la cadena vacia no vale se har�a con un ||.
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena tenga un n�mero arbitrario de caracteres excepto la b.
		System.out
				.print("E) Que la cadena tenga un n�mero arbitrario de caracteres excepto la b. Por ejemplo: "
						+ cadE);
		if (cadE.matches("[^bB]+"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena tenga un n�mero m�s peque�o que 300.
		System.out
				.print("F) Que la cadena tenga un n�mero m�s peque�o que 300. Por ejemplo: "
						+ cadF);
		if (cadF.matches("[0-2]?[0-9]{1,2}"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena sea un n�mero de tel�fono.
		System.out
				.print("G) Que la cadena sea un n�mero de tel�fono. Por ejemplo: "
						+ cadG);
		if (cadG.matches("[6-9]{1}[0-9]{8}"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena sea un DNI.
		System.out.print("H) Que la cadena sea un DNI. Por ejemplo: " + cadH);
		if (cadH.matches("[0-9]{8}[A-Z]{1}"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena sea un nombre, es decir, que no tenga espacios, que no
		// sea una cadena vac�a y que empiece por may�sculas.
		System.out
				.print("I) Que la cadena sea un nombre, es decir, que no tenga espacios, que no sea una cadena vac�a y que empiece por may�sculas: "
						+ cadI);
		if (cadI.matches("[A-Z������][a-z������]+"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");

		// Que la cadena empiece con vocal y luego tenga varias consonantes o
		// ninguna.
		System.out
				.print("J) Que la cadena empiece con vocal y luego tenga varias consonantes o ninguna. Por ejemplo: "
						+ cadJ);
		if (cadJ.matches("[a�e�i�o�u�A�E�I�O��][a-zA-Z&&[^a�e�i�o�u�A�E�I�O��]]*"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");
		
		// Que la cadena sea un correo electr�nico acabado en .com o en .es.
		System.out
				.print("K) Que la cadena sea un correo electr�nico acabado en .com o en .es. Por ejemplo: "
						+ cadK);
		if (cadK.matches("[A-Za-z0-9-_\\.]+@[a-z]+\\.(es|com)"))
			System.out.println(" se cumple");
		else
			System.out.println(" no se cumple");
	}

}
