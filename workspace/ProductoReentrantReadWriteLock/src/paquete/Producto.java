package paquete;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Alejandro on 25/10/2016.
 */
public class Producto {

    private ReentrantReadWriteLock lock;
    private int precio;
    private Random rnd;

    public Producto() {
        lock = new ReentrantReadWriteLock();
        rnd = new Random();
        precio = rnd.nextInt(100);
    }


    public void verPrecio() {
        lock.readLock().lock();
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(5) + 1);
            System.out.printf("%s ha consultado el precio y vale %d%n", Thread.currentThread().getName(), precio);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void cambiarPrecio() {
        Random rnd = new Random();
        lock.writeLock().lock();
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(5) + 1);
            precio = rnd.nextInt(500);
            System.out.printf("%s ha cambiado el precio y vale %d%n", Thread.currentThread().getName(), precio);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
