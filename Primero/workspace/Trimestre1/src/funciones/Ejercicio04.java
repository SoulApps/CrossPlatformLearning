package funciones;

import teclado.EnumLimite;
import teclado.Teclado;

import java.util.Scanner;

public class Ejercicio04 {

    public static void main(String[] args) {

        int num = 2;
        Teclado teclado = new Teclado();

        num = teclado.nextInt("Introduce un número entero positivo mayor que 1.", 1, EnumLimite.MAYOR);
        teclado.pichita();
        System.out.printf("CMD de %d: ", num);
        descomponerPrimos(num);
    }

    public static void descomponerPrimos(int num) {
        int n = 1, resultado = num;
        boolean error = false;

        do {
            n++;
            if (!Ejercicio03.comprobarPrimos(n) || error == false){
                do {
                    if (resultado % n == 0) {
                        resultado = resultado / n;
                        System.out.printf("%d ", n);
                        error = false;
                    }
                    else
                        error = true;
                } while (!error);
            }
        } while(resultado != 1);
    }
}
