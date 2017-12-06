package cadenas;

import teclado.Teclado;

public class Ejercicio06 {

	public static void main(String[] args) {
		int inicio, fin;
        char c;
        String s, s2;

        s = Teclado.next("Introduce una cadena");
        c = Teclado.nextChar("Introduce el carácter");
        inicio = s.indexOf(c);
        fin = s.lastIndexOf(c);
        s = s.substring(inicio + 1, fin);
        System.out.printf("La cadena que así: %s", s);
        System.out.printf("%nLa longitud de la cadena es: %d%n", s.length());

        s2 = s.replaceAll("[c && c]", "");
        System.out.println(s2);
        System.out.println(s2.length());
    }
}
