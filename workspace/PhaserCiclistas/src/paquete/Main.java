package paquete;

import java.util.concurrent.Phaser;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_CICLISTAS = 4;
        int i;
        MiPhaser secuenciador = new MiPhaser(NUM_CICLISTAS);
        Ciclista[] ciclistas = new Ciclista[NUM_CICLISTAS];


        for (i = 0; i < NUM_CICLISTAS; i++)
            ciclistas[i] = new Ciclista("Ciclista " + i, secuenciador);

        for (i = 0; i < NUM_CICLISTAS; i++) {
            try {
                ciclistas[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (i = 0; i < NUM_CICLISTAS; i++)
            ciclistas[i].start();
    }
}
