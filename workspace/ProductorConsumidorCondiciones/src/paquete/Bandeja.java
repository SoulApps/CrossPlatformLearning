package paquete;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alejandro on 18/10/2016.
 */
public class Bandeja {
    private ArrayList<Integer> bandeja;
    private ReentrantLock lock;
    private Condition hayEspacio;
    private Condition hayDonuts;

    public Bandeja() {
        bandeja = new ArrayList<>();
        lock = new ReentrantLock();
        hayEspacio = lock.newCondition();
        hayDonuts = lock.newCondition();
    }

    public void anhadirDonut(String nombre) {
        lock.lock();
        try {
            while (bandeja.size() >= 10) {
                System.out.println("Bandeja llena");
                hayDonuts.await();
            }
            bandeja.add(new Integer(0));
            System.out.printf("%s ha hecho un donut y hay %d donuts en la bandeja%n", nombre, bandeja.size());
            hayEspacio.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public void cogerDonut(String nombre) {
        lock.lock();
        try {
            while (bandeja.size() == 0) {
                System.out.println("Bandeja vacía");
                hayEspacio.await();
            }
            bandeja.remove(0);
            System.out.printf("%s se ha comido un donut y hay %d donuts en la bandeja%n", nombre, bandeja.size());
            hayDonuts.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
}
