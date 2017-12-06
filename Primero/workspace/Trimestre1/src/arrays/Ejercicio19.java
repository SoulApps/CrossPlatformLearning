package arrays;

import teclado.Teclado;

/**
 * Created by Alejandro on 02/12/2015.
 */
public class Ejercicio19 {
    public static void main(String[] args) {
        String array[];
        int i, j = 0, longitud = 1, aux = 0;
        String s;

        s = Teclado.next("Introduce un cadena");
        s = s.trim();
        s = s.replaceAll("[ ]+", " ");
        s += " ";

        //Cuento la longitud del array
        for (i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == ' ')
                longitud++;

        array = new String[longitud];


        //Encuentro y añado palabras al array cuando encuentra un espacio
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                array[j] = s.substring(aux, i);
                aux = i + 1;
                j++;
            }
        }

        for (i = 0; i < array.length; i++)
            System.out.printf("%s%n", array[i]);
    }
}
