package recursividad;

import teclado.EnumLimite;
import teclado.Teclado;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio10 {
    public static void main(String[] args) {
        int n, resultado, i;

        n = Teclado.nextInt("Introduce un número entero positivo", 0, EnumLimite.MAYOR);
        Teclado.pichita();

        for (i = 0; i <= n; i++) {
            resultado = fibonacci(i);
            if (i == 0)
                System.out.printf("1, %d", resultado);
            else
                System.out.printf(", %d", resultado);
        }
    }
    public static int fibonacci(int n) {
        int resultado = 0;
        if (resultado >= n) {
            resultado = 1;
        }
        else {
            resultado = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return resultado;
    }
}
