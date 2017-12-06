package arrays;

import teclado.Teclado;


/**
 * Created by Alejandro on 26/11/2015.
 */
public class Ejercicio15 {
    public static void main(String[] args) {
        boolean salir = false;
        int i, j, n = 0;
        int mayorAux = 0, cont = 0, contAux;
        int array[];
        char hist[][];
        char aux;
        String numeros = "";

        //Introduzco los datos.
        while (!salir) {
            n = Teclado.nextInt("Introduce un número");
            if (n >= 0)
                numeros += n; //Los añado a un string para luego comprobar su longitud y saber el tamaño correspondiente.
            else
                salir = true;
        }

        array = new int[numeros.length()];

        //Añado los números transformados en enteros al array.
        for (i = 0; i < numeros.length(); i++) {
            aux = numeros.charAt(i);
            n = Integer.parseInt(aux + "");
            array[i] = n;
        }

        //Encuentro el número que se repite más para hacer el límite del histograma.
        for (i = 0; i < array.length; i++) {
            mayorAux = array[i];
            contAux = 0;
            for (j = 0; j < array.length; j++) {
                if (mayorAux == array[j])
                    contAux++;
                if (contAux > cont) {
                    cont = contAux;
                }
            }
        }

        hist = new char[cont][10];


        //Lleno de espacios para mostrar luego bien el histograma.
        for (i = 0; i < hist.length ; i++) {
            for (j = 0; j < hist[i].length; j++) {
                hist[i][j] = ' ';
            }
        }

        //Relleno el histograma con asteriscos donde corresponda.
        for (i = 0; i < array.length; i++) {
            n = hist.length - 1;
            j = array[i];
            while (hist[n][j] != ' ') {//Voy colocando en la última posición para que se muestre hacia arriba.
                n--;
            }
                hist[n][j] = '*';
        }

        //Muestro el histograma.
        for (i = 0; i < hist.length; i++) {
            for (j = 0; j < hist[i].length; j++) {
                System.out.print(hist[i][j] + " ");
            }
            System.out.println();
        }

        //Muestro los números.
        for (i = 0; i <= 9; i++)
            System.out.print(i + " ");
    }
}
