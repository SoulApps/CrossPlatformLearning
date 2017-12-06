package arrays;

import teclado.Teclado;

import java.util.Arrays;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        double array[][][];
        double dato, mayor = 0;
        int i, j, k, iMayor = 0, jMayor = 0, kMayor = 0;

        i = Teclado.nextInt("Introduce el número de i");
        j = Teclado.nextInt("Introduce el número de j");
        k = Teclado.nextInt("Introduce el número de k");

        array = new double[i][j][k];

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                for (k = 0; k < array[i][j].length; k++) {
                    dato = Teclado.nextDouble("Introduce un número para introducir en la i " + i + ", la j " + j + " y la k " + k);
                    array[i][j][k] = dato;
                }
            }
        }

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                for (k = 0; k < array[i][j].length; k++) {
                    if (array[i][j][k] > mayor) {
                        mayor = array[i][j][k];
                        iMayor = i;
                        jMayor = j;
                        kMayor = k;
                    }
                }
            }
        }
        System.out.printf("El mayor es %f y se encuentra en la posición %d %d %d", mayor, iMayor, jMayor, kMayor);
    }
}
