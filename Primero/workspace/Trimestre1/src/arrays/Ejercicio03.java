package arrays;

import teclado.Teclado;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		int tamano, i, aux = 0;
		int array[];

		tamano = Teclado.nextInt("Introduce el tamaño del array");
		array = new int [tamano];
		System.out.println(array.length);

        for (i = 0; i < array.length; i++) {
            array[i] = Teclado.nextInt("Introduce el valor de la posición " + i);
        }
        Teclado.pichita();

		
		for (i = 0; i < array.length; i++) {
			aux += array[i];
		}
        System.out.printf("El resultado es: %d", aux);
	}

}
