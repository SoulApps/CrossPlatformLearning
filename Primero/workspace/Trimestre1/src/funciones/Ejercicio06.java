package funciones;

import teclado.Teclado;

/**
 * Created by Alejandro on 11/11/2015.
 */
public class Ejercicio06 {
    //1.-Introduzco los datos por teclado.
    //2.-Compruebo el mayor y el menor.
    //3.-Con un bucle voy comprobando desde el número menor un número que siendo divisor de los introducidos su módulo sea 0.
    public static void main(String[] args) {
        int n1, n2;
        Teclado teclado = new Teclado();

        //1.-Introduzco los datos por teclado.
        n1 = teclado.nextInt("Introduce un número entero");
        n2 = teclado.nextInt("Introduce otro entero");
        teclado.pichita();
        System.out.println(maxComunDivisor(n1, n2));
    }

    public static int maxComunDivisor(int n1, int n2) {
        boolean error = false;
        int mcd = 0, mayor, menor, aux;

        //2.-Compruebo el mayor y el menor.
        if (n1 > n2) {
            mayor = n1;
            menor = n2;
        }
        else {
            mayor = n2;
            menor = n1;
        }

        //3.-Con un bucle voy comprobando desde el número menor un número que siendo divisor de los introducidos su módulo sea 0.
        aux = menor;
        do {
            if(mayor % aux == 0 && menor % aux == 0) {
                mcd = aux;
                error = false;
            }
            else {
                aux--;
                error = true;
            }
        }
        while (error);
        return mcd;
    }
}
