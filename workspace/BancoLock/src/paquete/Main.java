package paquete;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Cuenta cuenta = new Cuenta();
        Hilo hilos[] = new Hilo[3];

        for (i = 0; i < 3; i++) {
            hilos[i] = new Hilo(cuenta);
            hilos[i].start();
        }

        for (i = 0; i < 3; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cuenta.getSaldo());
    }
}
