package paquete;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Impresora {

    private ReentrantLock lock;

    public Impresora() {
        lock = new ReentrantLock(true);
    }

    public void imprimir() {
        Random rnd = new Random();
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(5) + 1);
            System.out.printf("%s ha imprimido algo%n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
