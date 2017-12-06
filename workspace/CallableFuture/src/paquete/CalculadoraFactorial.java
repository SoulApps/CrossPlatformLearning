package paquete;

import java.util.concurrent.Callable;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class CalculadoraFactorial implements Callable<Integer> {

    private int numero;

    public CalculadoraFactorial(int numero) {
        this.numero = numero;
    }

    @Override
    public Integer call() throws Exception {
        if (numero == 0 || numero == 1)
            return 1;

        for (int i = 2; i < numero; i++)
            numero *= i;
        return numero;
    }
}
