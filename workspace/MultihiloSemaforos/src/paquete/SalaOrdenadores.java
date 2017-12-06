package paquete;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alejandro on 07/11/2016.
 */
public class SalaOrdenadores {

    private int NUM_ORDENADORES = 4;
    private Semaphore semaforo;
    private ReentrantLock cerrojo;
    private Random rnd;
    private boolean ordenadores[];

    public SalaOrdenadores() {
        ordenadores = new boolean[NUM_ORDENADORES];
        Arrays.fill(ordenadores, true);
        semaforo = new Semaphore(NUM_ORDENADORES);
        cerrojo = new ReentrantLock();
        rnd = new Random();
    }

    public void intentarTrabajar(String nombre) {
        if (semaforo.tryAcquire())
            trabajar(nombre);
        else
            System.out.printf("%s ha suspendido por vago%n", nombre);

        semaforo.release();
    }

    public void trabajar(String nombre) {
        int i;
        try {
            semaforo.acquire();

            i = asignarOrdenador();
            System.out.printf("%s está usando el ordenador %d%n", nombre, i);
            Thread.sleep(rnd.nextInt((5) + 1) * 1000);
            quitarOrdenador(i);
            System.out.printf("%s ya ha dejado de usar el ordenador %d%n", nombre, i);

            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int asignarOrdenador() {
        int i = 0;
        boolean salir = false;
        cerrojo.lock();
        while (i < ordenadores.length && !salir) {
            if (ordenadores[i]) {
                ordenadores[i] = false;
                salir = true;
            }
            else
                i++;
        }
        cerrojo.unlock();

        return i;
    }

    public void quitarOrdenador(int i) {
        ordenadores[i] = true;
    }
}
