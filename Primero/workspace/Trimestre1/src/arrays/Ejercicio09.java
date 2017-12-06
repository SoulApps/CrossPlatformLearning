package arrays;

import teclado.Teclado;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio09 {
    public static void main(String[] args) {
        int array[];
        int tamano, i, compare, j = 0;
        String s = "";

        tamano = Teclado.nextInt("Introduce el tamaño del array");
        array = new int[tamano];

        for (i = 0; i < array.length; i++) {
            array[i] = Teclado.nextInt("Introduce el valor de la posición " + i);
        }

        compare = Teclado.nextInt("Introduce el número a buscar");
        System.out.printf("Las posiciones que contienen %d son: ", compare);
        for (i = 0; i < array.length; i++) {
            if (array[i] == compare) {
                j++;
                if (j == 1)
                    System.out.print(String.valueOf(i));
                else
                    System.out.print(", " + String.valueOf(i));
            }
        }
        System.out.printf("%nEl número %d se ha repetido por tanto %d veces%n", compare, j);
    }
}
