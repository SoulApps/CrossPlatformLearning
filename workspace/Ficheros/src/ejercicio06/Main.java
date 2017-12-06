package ejercicio06;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Alejandro on 06/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        File origen, destino1, destino2, destino3, destinoFinal;

        origen = new File(".\\src\\ejercicio06\\Origen.dat");
        destino1 = new File(".\\src\\ejercicio06\\Destino1.txt");
        destino2 = new File(".\\src\\ejercicio06\\Destino2.txt");
        destino3 = new File(".\\src\\ejercicio06\\Destino3.txt");
        destinoFinal = new File(".\\src\\ejercicio06\\DestinoFinal.txt");


        try {
            separar(origen, destino1, destino2, destino3);
            unir(destino1, destino2, destino3, destinoFinal);
        } catch (IOException e) {

        }
    }

    public static void separar(File origen, File destino1, File destino2, File destino3) throws IOException {
        final int TAMANHO = 15;
        int i = 0, j = 0, k;
        char array[] = new char[15];
        BufferedReader leerOrigen;
        BufferedWriter escribirDestino1, escribirDestino2, escribirDestino3;

        leerOrigen = new BufferedReader(new FileReader(origen));
        escribirDestino1 = new BufferedWriter(new FileWriter(destino1));
        escribirDestino2 = new BufferedWriter(new FileWriter(destino2));
        escribirDestino3 = new BufferedWriter(new FileWriter(destino3));


        while (leerOrigen.read(array, i, TAMANHO) != -1) {
            for (k = 0; k < 15; k++) {
                if (array[k] != (char) 0) {
                    if (k < 5)
                        escribirDestino1.write(array[k]);
                    else if (k < 10)
                        escribirDestino2.write(array[k]);
                    else
                        escribirDestino3.write(array[k]);
                }
            }
            Arrays.fill(array, (char) 0);
        }

        leerOrigen.close();
        escribirDestino1.close();
        escribirDestino2.close();
        escribirDestino3.close();
    }

    public static void unir(File origen1, File origen2, File origen3, File destino) throws IOException {
        final int TAMANHO = 5;
        String s = "";
        int i, j = 0, k = 0, i1 = 0, i2 = 0, i3 = 0;
        char array[] = new char[15], array1[] = new char[5], array2[] = new char[5], array3[] = new char[5];
        BufferedReader leerOrigen1, leerOrigen2, leerOrigen3;
        BufferedWriter escribirDestino;

        leerOrigen1 = new BufferedReader(new FileReader(origen1));
        leerOrigen2 = new BufferedReader(new FileReader(origen2));
        leerOrigen3 = new BufferedReader(new FileReader(origen3));
        escribirDestino = new BufferedWriter(new FileWriter(destino));


        while (leerOrigen1.read(array, k, TAMANHO) != -1) {
            for (i = 0; i < TAMANHO; i++)
                if (array[i] != (char) 0)
                    s += array[i];
            Arrays.fill(array, (char) 0);
        }
        array1 = new char[s.length()];
        for (i = 0; i < s.length(); i++)
            array1[i] = s.charAt(i);


        s = "";
        while (leerOrigen2.read(array, k, TAMANHO) != -1) {
            for (i = 0; i < TAMANHO; i++)
                if (array[i] != (char) 0)
                    s += array[i];
            Arrays.fill(array, (char) 0);
        }
        array2 = new char[s.length()];
        for (i = 0; i < s.length(); i++)
            array2[i] = s.charAt(i);


        s = "";
        while (leerOrigen3.read(array, k, TAMANHO) != -1) {
            for (i = 0; i < TAMANHO; i++)
                if (array[i] != (char) 0)
                    s += array[i];
            Arrays.fill(array, (char) 0);
        }
        array3 = new char[s.length()];
        for (i = 0; i < s.length(); i++)
            array3[i] = s.charAt(i);


        while (i1 < array1.length || i2 < array2.length || i3 < array3.length) {
            if (j == 0) {
                for (i = i1; i < i1 + TAMANHO && i < array1.length; i++)
                    escribirDestino.write(array1[i]);
                i1 += 5;
                j++;
            } else if (j == 1) {
                for (i = i2; i < i2 + TAMANHO && i < array2.length; i++)
                    escribirDestino.write(array2[i]);
                i2 += 5;
                j++;
            } else if (j == 2) {
                for (i = i3; i < i3 + TAMANHO && i < array3.length; i++)
                    escribirDestino.write(array3[i]);
                i3 += 5;
                j = 0;
            } else
                j++;
        }

        /*int l = 0;
        while (leerOrigen1.read(array, 0, 5) != -1 || leerOrigen2.read(array, 0 , 5) != -1 || leerOrigen3.read(array, 0 , 5) != -1) {
            for (l = 0; l < 15; l++) {
                if (array[l] != (char) 0)
                    System.out.print(array[l]);
            }
            Arrays.fill(array, (char) 0);
        }*/


        leerOrigen1.close();
        leerOrigen2.close();
        leerOrigen3.close();
        escribirDestino.close();
    }
}
