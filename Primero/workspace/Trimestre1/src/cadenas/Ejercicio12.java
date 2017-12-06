package cadenas;

import teclado.Teclado;

/**
 * Created by Alejandro on 16/11/2015.
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        int i;
        char c = 0, asterisco = '*';
        String cadena, resultado = "";
        cadena = Teclado.next("Introduce una cadena");
        c = Teclado.nextChar("Introduce un carácter");
        for (i = 0; i <= cadena.length() - 1; i++) {
            if (cadena.charAt(i) != c)
                resultado += cadena.charAt(i);
            else
                resultado += '*';
        }
        System.out.println(resultado);
    }
}
