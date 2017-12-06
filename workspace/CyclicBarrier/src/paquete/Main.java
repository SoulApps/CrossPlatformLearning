package paquete;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_JUGADORES = 4;
        int i;
        CyclicBarrier barrera = new CyclicBarrier(5, () -> System.out.println("Empieza el partido"));
        Arbitro arbitro = new Arbitro("Árbitro", barrera);
        Jugador[] jugadores = new Jugador[NUM_JUGADORES];



        for (i = 0; i < NUM_JUGADORES; i++)
            jugadores[i] = new Jugador("Jugador " + i, barrera);

        arbitro.start();

        for (i = 0; i < NUM_JUGADORES; i++)
            jugadores[i].start();
    }
}
