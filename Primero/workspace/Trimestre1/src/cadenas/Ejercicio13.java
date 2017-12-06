package cadenas;

import teclado.Teclado;

public class Ejercicio13 {

    /*
        1.-Pido datos al usuario.
        2.-Limpio espacios.
               2.1.-Limpio espacios de delante y atrás.
               2.2.-Limpio espacios adicionales.
        3.-Compruebo que se haya metido alguna palabra (no solo espacios o nada).
        4.-Cuento espacios para contar las palabras. Por cada espacio, una palabra más.
     */
    public static void main(String[] args) {
        int i, palabra = 0;
        String s;

        //1.-Pido datos al usuario.
        s = Teclado.next("Inroduce una cadena");
        //2.-Limpio espacios.
        s = s.trim(); //2.1.-Limpio espacios de delante y atrás
        s = s.replaceAll("[ ]+", " "); //2.2-Quito espacios adicionales
        if ((s.length() == 1 && s.charAt(0) == ' ') || s.length() == 0) { //3.-Compuebo que me haya metido alguna palabra
            palabra = 0;
        }
        else {
            palabra = 1; //Palabra está inicializada en 1 para contar palabras aunque no tenga espacios y sí letras.
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') { //4.-Cuento espacios para contar las palabras. Por cada espacio, una palabra más.
                    palabra++;
                }
            }
        }
        if (palabra == 1)
            System.out.println("Hay 1 palabra.");
        else if (palabra == 0)
            System.out.println("No hay palabras.");
        else
            System.out.printf("Hay %d palabras.", palabra);
    }
}
