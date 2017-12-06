package recursividad;

import teclado.EnumLimite;
import teclado.Teclado;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio07 {
    public static void main(String[] args) {
        int n;
        n = Teclado.nextInt("Introduce un número entero positivo", 0, EnumLimite.MAYOR);
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        int resultado = 1;
        if (n == 1)
            resultado = 1;
        else
            resultado = n * factorial(n - 1);
        return resultado;
    }
}
