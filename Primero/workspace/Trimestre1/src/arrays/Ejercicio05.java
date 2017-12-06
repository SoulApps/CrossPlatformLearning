package arrays;

import java.util.Scanner;

public class Ejercicio05 {

    public static void main(String[] args) {

        int array[] = new int[5];
        int i, aux = 0;
        Scanner teclado = new Scanner(System.in);

        for (i = 0; i < array.length; i++) {
            array[i] = teclado.nextInt();
        }

        for (i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                if (array[i] % 2 == 0) {
                    System.out.printf("Posición: %d  Dato: %d\n", i, array[i]);
                    aux += array[i];
                    System.out.println("Suma: " + aux);
                }
            }
        }

        teclado.close();

    }

}
