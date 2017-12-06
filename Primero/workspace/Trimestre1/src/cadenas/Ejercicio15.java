package cadenas;

import teclado.Teclado;

/**
 * Created by Alejandro on 16/11/2015.
 */
public class Ejercicio15 {
    public static void main(String[] args) {
        int i;
        String sPalindroma = "Dabale arroz a la zorra el abad", sResultado = "";

        sPalindroma = Teclado.next("Introduce una cadena para comprobar si es palíndroma");
        sPalindroma = sPalindroma.replace(" ", "");
        sPalindroma = sPalindroma.toLowerCase();
        for (i = sPalindroma.length() - 1; i >= 0; i--) {
            sResultado += sPalindroma.charAt(i);
        }
        if (sPalindroma.equalsIgnoreCase(sResultado))
            System.out.println("Es palíndroma.");
        else
            System.out.println("No es palíndroma.");
    }
}
