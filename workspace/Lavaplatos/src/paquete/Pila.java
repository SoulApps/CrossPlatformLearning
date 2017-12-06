package paquete;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alejandro on 10/10/2016.
 */
public class Pila {

    private String nombre;
    private ArrayList<Integer> platos;
    private ReentrantLock lock;
    private Condition pilaVacia;

    public Pila(String nombre) {
        this.nombre = nombre;
        platos = new ArrayList<>();
        lock = new ReentrantLock();
        pilaVacia = lock.newCondition();
    }

    public void ponerPlato(Integer plato) {
        lock.lock();
        platos.add(plato);
        System.out.printf("Plato %s puesto en %s%n", plato, nombre);
        pilaVacia.signalAll();
        lock.unlock();
    }

    public Integer quitarPlato() {
        Integer i = null;
        lock.lock();
        try {
            while (platos.isEmpty()) {
                pilaVacia.await();
            }
            i = platos.get(0);
            System.out.printf("Plato %s quitado de %s%n", i, nombre);
            platos.remove(0);
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

        return i;
    }
}
