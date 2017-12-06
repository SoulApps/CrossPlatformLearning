package cadenas;

import teclado.Teclado;

public class Ejercicio05 {

    /*  1.-Introduzco la cadena principal y la que tengo que buscar.
        2.-Voy recorriendo la cadena principal y voy introduciendo los caracteres en otra cadena auxiliar.
        3.-Si encuentro un espacio o encuentro una coincidencia entonces la cadena auxiliar pasa a estar vacía.
            3.1.-Si encuentro una coincidencia aumento el valor de un contador.
        4.-Muestro el número de veces que ha encontrado esa cadena.

     */
	public static void main(String[] args) {

		int i, cont = 0;
		String s1, s2, resultado = "";

        //1.-Introduzco la cadena principal y la que tengo que buscar.
		s1 = Teclado.next("Introduce una cadena");
		s2 = Teclado.next("Introduce la cadena a buscar");
		Teclado.pichita();

        //2.-Voy recorriendo la cadena principal y voy introduciendo los caracteres en otra cadena auxiliar.
		for (i = 0; i < s1.length(); i++) {
            resultado += s1.charAt(i);
            if (s1.charAt(i) == ' ')
                resultado = ""; //3.-Si encuentro un espacio o encuentro una coincidencia entonces la cadena auxiliar pasa a estar vacía.
            if (resultado.equals(s2)) {
                resultado = ""; //3.-Si encuentro un espacio o encuentro una coincidencia entonces la cadena auxiliar pasa a estar vacía.
                cont++; //3.1.-Si encuentro una coincidencia aumento el valor de un contador.
            }
        }

        //4.-Muestro el número de veces que ha encontrado esa cadena.
		System.out.printf("La cadena se repite %d veces", cont);
	}
}
