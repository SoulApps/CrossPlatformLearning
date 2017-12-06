package paquete;

/**
 * Created by Alejandro on 17/10/2016.
 */
public class Palillo {
    private int n;
    private boolean cogido;

    public Palillo(int n) {
        this.n = n;
        cogido = false;
    }

    public synchronized void cogerPalillo(int filosofo) {
        while (cogido) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        cogido = true;
        System.out.printf("El filósofo %d ha cogido el palillo %d%n", filosofo, n);
    }

    public synchronized void soltarPalillo(int filosofo) {
        cogido = false;
        System.out.printf("El filósofo %d ha soltado el palillo %d%n", filosofo, n);
        notifyAll();
    }
}
