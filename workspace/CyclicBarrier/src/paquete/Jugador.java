package paquete;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Jugador extends Thread {

    private String nombre;
    private CyclicBarrier barrera;
    private Random rnd;

    public Jugador(String nombre, CyclicBarrier barrera) {
        this.nombre = nombre;
        this.barrera = barrera;
        rnd = new Random();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(rnd.nextInt(5000));
            System.out.println(nombre + " está listo");
            barrera.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
