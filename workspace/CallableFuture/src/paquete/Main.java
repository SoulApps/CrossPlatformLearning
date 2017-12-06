package paquete;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int MAX = 10;
        int i, suma = 0;
        Integer[] numeros = new Integer[MAX];
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        CalculadoraFactorial calculadoraFactorial;
        ArrayList<Future<Integer>> resultados = new ArrayList<>();

        for (i = 0; i < MAX; i++) {
            numeros[i] = i;
            calculadoraFactorial = new CalculadoraFactorial(numeros[i]);
            resultados.add(ejecutor.submit(calculadoraFactorial));
        }


        for (i = 0; i < MAX; i++) {
            try {
                suma += resultados.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(suma);

        ejecutor.shutdown();
    }
}
