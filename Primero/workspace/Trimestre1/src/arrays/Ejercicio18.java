package arrays;

/**
 * Created by Alejandro on 02/12/2015.
 */
public class Ejercicio18 {
    public static void main(String[] args) {
        boolean noPerfe = false;
        int array[][] = {{4, 15, 14, 1}, {9, 6, 7, 12}, {5, 10, 11, 8}, {16, 3, 2, 13}};
        //int array[][] = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int i, j, perfe = 0, aux = 0;

        //Filas
        for (i = 0; i < array.length; i++) {
            aux = 0;
            for (j = 0; j < array[i].length; j++) {
                aux += array[i][j];
            }
            if (i == 0)
                perfe = aux;
            if (aux != perfe)
                noPerfe = true;
        }

        //Columnas
        for (i = 0; i < array.length; i++) {
            aux = 0;
            for (j = 0; j < array[i].length; j++) {
                aux += array[j][i];
            }
            if (aux != perfe)
                noPerfe = true;
        }

        //Diagonal principal
        aux = 0;
        for (i = 0, j = 0; i < array.length; i++, j++) {
            aux += array[i][j];
        }
        if (aux != perfe)
            noPerfe = true;

        //Diagonal secundaria
        aux = 0;
        for (i = array.length - 1, j = 0; i >= 0; i--, j++) {
            aux += array[i][j];
        }
        if (aux != perfe)
            noPerfe = true;


        //Resultado
        if (!noPerfe)
            System.out.println("Es perfecto");
        else
            System.out.println("No es perfecto");
    }
}
