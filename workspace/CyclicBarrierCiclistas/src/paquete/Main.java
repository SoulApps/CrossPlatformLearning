package paquete;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_CICLISTAS = 4;
        int i;
        CyclicBarrier barrera = new CyclicBarrier(NUM_CICLISTAS, new Runnable() {
            int etapa = 1;
            @Override
            public void run() {
                System.out.println("Ha finalizado la etapa " + etapa++);
            }
        });
        Ciclista[] ciclistas = new Ciclista[NUM_CICLISTAS];


        for (i = 0; i < NUM_CICLISTAS; i++)
            ciclistas[i] = new Ciclista("Jugador " + i, barrera);

        for (i = 0; i < NUM_CICLISTAS; i++)
            ciclistas[i].start();
    }
}
