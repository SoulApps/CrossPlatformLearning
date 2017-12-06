package recursividad;

import teclado.EnumLimite;
import teclado.Teclado;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio08 {
    public static void main(String[] args) {
        int n, potencia;

        n = Teclado.nextInt("Introduce un número postivio", 0, EnumLimite.MAYOR);
        potencia = Teclado.nextInt("Introduce una potencia positiva", 0, EnumLimite.MAYOR);
        System.out.println(potencia(n, potencia));
    }
    public static int potencia(int n, int potencia) {
        int resultado = n, i;
        if (potencia > 1) {
           for (i = 0; i < potencia; i++)
                resultado = n * potencia(n, potencia - 1);
        }
        return resultado;
    }
}
