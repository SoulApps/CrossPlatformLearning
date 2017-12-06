package funciones;

import teclado.Teclado;

public class Ejercicio05 {
    public static void main(String[] args) {
        final int MAX = 10000;
        int n, i;
        boolean b;
        n = Teclado.nextInt("Introduce un número");

        b = perfecto(n);
        if (b)
            System.out.printf("El número %d es perfecto.%n", n);
        else
            System.out.printf("El número %d no es perfecto.%n", n);

        comprobarPerfecto(n);

        for (i = 0; i <= MAX; i++)
            comprobarPerfecto(i);
    }

    public static boolean perfecto(int n) {
        int aux = 0;
        int i = 0;
        boolean bool = false;

        while (aux < n) {
            aux += i;
            if (aux <= n)
            i++;
        }
        if (aux == n)
            bool = true;
        else
            bool = false;
        return bool;
    }

    public static void comprobarPerfecto(int n) {
        int aux = 0;
        int i = 0;

        if (perfecto(n)) {
            while (aux <= n) {
                aux += i;
                if (aux <= n)
                    System.out.println(aux);
                i++;
            }
         }
    }
}
