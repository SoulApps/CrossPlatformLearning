package paquete;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Impresora impresora = new Impresora();
        Thread hilos[] = new Thread[10];

        for (i = 0; i < 10; i++)
            hilos[i] = new Thread(new Hilo(impresora));

        for (i = 0; i < 10; i++)
            hilos[i].start();

        for (i = 0; i < 10; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Ciao");
    }
}
