package arrays;

import teclado.EnumRango;
import teclado.Teclado;

/**
 * Created by Alejandro on 03/12/2015.
 */
public class Ejercicio20 {
    public static void main(String[] args) {
        byte menu, submenu, tamano;
        int i;
        String palabras[][];
        String palabra;

        tamano = Teclado.nextByte("Introduce el tamaño");
        palabras = new String[tamano][];

        for (i = 0; i < palabras.length; i++) {
            palabra = Teclado.next("Introduce varias palabras separadas por espacios");
            palabras[i] = palabra.split(" ");
        }

       do {
           menu = Teclado.nextByte("¿Qué quieres hacer?\n1. Impares o pares\n2. Búsqueda\n3. Salir", (byte) 1, (byte) 3, EnumRango.AMBOSINCLUIDOS);
           switch (menu) {
               case 1:
                   do {
                       submenu = Teclado.nextByte("¿Qué quieres hacer?\n1. Impares\n2. Pares\n3. Salir", (byte) 1, (byte) 3, EnumRango.AMBOSINCLUIDOS);
                       switch (submenu) {
                           case 1:
                               System.out.println(impares(palabras));
                               break;
                           case 2:
                               System.out.println(pares(palabras));
                               break;
                           case 3:
                               System.out.println("De vuelta al menú principal");
                               break;
                       }
                   } while (submenu != 3);
                   break;
               case 2:
                   System.out.println(busqueda(palabras));
                   menu = 0;
                   break;
               case 3:
                   System.out.println("Adiós");
                   break;
           }
       } while(menu != 3);
    }

    public static String impares(String palabras[][]) {
        String frase = "";
        int i, j;

        for (i = 0; i < palabras.length; i++) {
            for (j = 0; j < palabras[i].length; j++) {
                if ((i + j) % 2 != 0)
                    frase += palabras[i][j] + " ";
            }
        }
        frase = frase.trim();
        return frase;
    }

    public static String pares(String palabras[][]) {
        String frase = "";
        int i, j;

        for (i = 0; i < palabras.length; i++) {
            for (j = 0; j < palabras[i].length; j++) {
                if ((i + j) % 2 == 0)
                    frase += palabras[i][j] + " ";
            }
        }
        frase = frase.trim();
        return frase;
    }

    public static String busqueda(String palabras[][]) {
        String frase = "";
        int i, j, letra;
        char c;
        boolean b = false;

        c = Teclado.nextChar("¿Qué carácter deseas buscar?");

        for (i = 0; i < palabras.length; i++) {
            for (j = 0; j < palabras[i].length; j++) {
                for (letra = 0; letra < palabras[i][j].length(); letra++) {
                    if (palabras[i][j].charAt(letra) == c) {
                        frase += palabras[i][j] + " ";
                        frase = frase.replace(c, '*');
                        b = true;
                    }
                }
            }
        }
        if (!b)
            System.out.println("No se ha encontrado nada");
        frase = frase.trim();
        return frase;
    }
}
