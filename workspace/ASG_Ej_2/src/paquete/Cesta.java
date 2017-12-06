package paquete;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class Cesta {

    private int numMunhecas;
    private String nombre;
    private Lock lock;
    private Condition munhecaAnhadida;

    public Cesta(String nombre) {
        this.nombre = nombre;
        numMunhecas = 0;
        lock = new ReentrantLock();
        munhecaAnhadida = lock.newCondition();
    }

    public void quitarMunheca() {
        lock.lock();
        while (numMunhecas == 0) {
            try {
                munhecaAnhadida.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numMunhecas--;
        System.out.printf("Se ha quitado una muñeca de la cesta %s%n", nombre);
        lock.unlock();
    }

    public void anhadirMunheca() {
        lock.lock();
        numMunhecas++;
        munhecaAnhadida.signalAll();
        System.out.printf("Se ha añadido una muñeca a la cesta %s%n", nombre);
        lock.unlock();
    }
}
