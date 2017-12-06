package paquete;

/**
 * Created by Alejandro on 17/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int CINCO = 5;
        int i;
        Thread filosofos[] = new Thread[CINCO];
        Palillo palillos[] = new Palillo[CINCO];

        for (i = 0; i < CINCO; i++)
            palillos[i] = new Palillo(i);

        for (i = 0; i < CINCO; i++)
            filosofos[i] = new Thread(new Filosofo(i, palillos[i], palillos[(i + 1)%CINCO]));

        for (i = 0; i < CINCO; i++)
            filosofos[i].start();

    }
}
