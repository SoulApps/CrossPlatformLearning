package arrays;

import teclado.EnumLimite;
import teclado.EnumRango;
import teclado.Teclado;

/**
 * Created by Alejandro on 04/12/2015.
 */
public class Ejercicio22 {
    public static void main(String[] args) {
        int array[][] = {{1, 2}, {2, 2}};
        int i, j, k;
        int tamano, posicionI, posicionJ;
        boolean salir = true;
        String aux = "", aux2 = "";

        do {
            tamano = Teclado.nextInt("Introduce el tamaño del cuadrado", 0, EnumLimite.MAYOR);
            array = new int[tamano][tamano];

            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    posicionI = i + 1;
                    posicionJ = j + 1;
                    array[i][j] = Teclado.nextInt("Introduce con un número del 0 al 9 el valor para la fila " + posicionI + " y la columna " + posicionJ, 0, 9, EnumRango.AMBOSINCLUIDOS);
                }
            }


            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }


            //Filas
            for (i = 0; i < array.length; i++) {
                aux = "";
                aux2 = "";
                for (j = 0; j < array[i].length; j++) {
                    aux += array[i][j];
                }
                for (k = aux.length() - 1; k >= 0; k--) {
                    aux2 += aux.charAt(k);
                }
                if (aux.equals(aux2))
                    System.out.printf("La fila %d es capicúa\n", i + 1);
            }

            //Columnas
            for (i = 0; i < array.length; i++) {
                aux = "";
                aux2 = "";
                for (j = 0; j < array[i].length; j++) {
                    aux += array[j][i];
                }
                for (k = aux.length() - 1; k >= 0; k--) {
                    aux2 += aux.charAt(k);
                }
                if (aux.equals(aux2))
                    System.out.printf("La columna %d es capicúa\n", i + 1);
            }

            //Diagonal principal
            aux = "";
            aux2 = "";
            for (i = 0, j = 0; i < array.length; i++, j++) {
                aux += array[i][j];
            }
            for (k = aux.length() - 1; k >= 0; k--) {
                aux2 += aux.charAt(k);
            }
            if (aux.equals(aux2))
                System.out.println("La diagonal principal es capicúa");

            //Diagonal secundaria
            aux = "";
            aux2 = "";
            for (i = array.length - 1, j = 0; i >= 0; i--, j++) {
                aux += array[i][j];
            }
            for (k = aux.length() - 1; k >= 0; k--) {
                aux2 += aux.charAt(k);
            }
            if (aux.equals(aux2)) {
                System.out.println("La diagonal secundaria es capicúa");
            }


            salir = Teclado.nextBoolean("¿Quieres volver a comprobar algún cuadrado?", "Sí", "No");
        } while (salir);
    }
}
