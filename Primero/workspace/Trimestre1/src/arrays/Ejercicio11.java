package arrays;

import teclado.Teclado;

public class Ejercicio11 {
    public static void main(String[] args) {
        int array[][], limite1, limite2, i = 0, j = 0, sumai[], sumaj[], cont = 0, k;
        limite1 = Teclado.nextInt("Introduce el número de filas: ");
        limite2 = Teclado.nextInt("Introduce el número de columnas: ");
        array = new int[limite1][limite2];
        sumai = new int[limite1];
        sumaj = new int[limite2];
        for (i = 0; i <= array.length - 1; i++)
            for (j = 0; j <= array[i].length - 1; j++)
                array[i][j] = Teclado.nextInt("Introduce el número fila " + i + " columna " + j + ": ");
        for (i = 0; i <= array.length - 1; i++) {
            for (j = 0; j <= array[i].length - 1; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }

        for (i = 0; i <= array.length - 1; i++) {
            for (j = 0; j <= array[i].length - 1; j++) {
                sumaj[i] += array[i][j];
            }
        }
        for (i = 0; i <= array.length - 1; i++) {
            for (j = 0; j <= array[i].length - 1; j++) {
                sumai[i] += array[j][i];
            }
        }
        for (i = 0; i <= sumai.length - 1; i++)
            System.out.printf("Suma columna %d %d\n", i, sumai[i]);
        for (i = 0; i <= sumaj.length - 1; i++)
            System.out.printf("Suma de las filas %d %d\n", i, sumaj[i]);
    }
}
