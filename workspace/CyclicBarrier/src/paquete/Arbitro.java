package paquete;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Arbitro extends Thread {

    private String nombre;
    private CyclicBarrier barrera;

    public Arbitro(String nombre, CyclicBarrier barrera) {
        this.nombre = nombre;
        this.barrera = barrera;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(nombre + " está listo");
            barrera.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
