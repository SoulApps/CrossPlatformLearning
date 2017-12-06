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
            hilos[i].start();
        }

        for (i = 0; i < 9; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("Ya he terminado");
    }
}
