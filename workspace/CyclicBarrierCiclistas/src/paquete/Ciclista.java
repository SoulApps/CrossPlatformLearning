package paquete;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Ciclista extends Thread {

    private static int puesto;
    private String nombre;
    private CyclicBarrier barrera;
    private Random rnd;

    public Ciclista(String nombre, CyclicBarrier barrera) {
        this.nombre = nombre;
        this.barrera = barrera;
        rnd = new Random();
        puesto = 1;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(rnd.nextInt(5000));
                synchronized (this) {
                    System.out.println(nombre + " ha llegado a la meta en el puesto " + puesto);
                    puesto++;
                }
                barrera.await();
                puesto = 1;
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
