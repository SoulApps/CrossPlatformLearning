package paquete;

/**
 * Created by Alejandro on 26/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Thread hilos[] = new Thread[10];

        for (i = 0; i < 9; i++) {
            hilos[i] = new Thread(new Tabla(i + 1), "Hilo-" + (i + 1));

            if (i % 2 == 0)
                hilos[i].setPriority(Thread.MIN_PRIORITY);
            else
                hilos[i].setPriority(Thread.MAX_PRIORITY);
        }

        for (i = 0; i < 9; i++)
            hilos[i].start();

        System.out.println("Terminé");
    }
}
