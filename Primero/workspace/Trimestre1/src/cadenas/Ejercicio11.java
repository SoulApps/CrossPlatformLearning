package cadenas;

import teclado.Teclado;

/**
 * Created by Alejandro on 16/11/2015.
 */
public class Ejercicio11 {
    public static void main(String[] args) {
        boolean error = false;
        int aux, resultado = 0, cociente = 0, resto;
        final int DIVISOR = 10;
        String s;

        do {
            s = Teclado.next("Introduce una cadena");
            s = s.replaceAll("[^1-9]", "");
            if (s.equals("")) {
                System.out.println("Error");
                error = true;
            }
            else {
                error = false;
                cociente = Integer.parseInt(s);
                while (cociente != 0) {
                    resto = cociente % DIVISOR;
                    cociente /= DIVISOR;
                    resultado += resto;
                }
            }
        } while(error);
        System.out.println(resultado);
    }
}
