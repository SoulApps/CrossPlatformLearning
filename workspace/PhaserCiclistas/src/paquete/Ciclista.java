package paquete;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * Created by Alejandro on 14/11/2016.
 */
public class Ciclista extends Thread {

    private MiPhaser secuenciador;
    private Random rnd;

    public Ciclista(String nombre, MiPhaser secuenciador) {
        super(nombre);
        this.secuenciador = secuenciador;
        rnd = new Random();
    }

    @Override
    public void run() {
        secuenciador.arriveAndAwaitAdvance();
        //System.out.printf("%s está listo%n", getName());

        for (int i = 0; i < 2; i++)
            pedalear();

        secuenciador.arriveAndDeregister();
        System.out.printf("%s se ha ido%n", getName());
    }

    public void pedalear() {
        secuenciador.arriveAndAwaitAdvance();
    }

    //Si la clase tuviera secuenciador propio normal y con un sleep.
    /*public void pedalear() {
        System.out.printf("%s ha llegado a %s en el puesto %d y quedan %d por llegar%n", nombre, secuenciador.getPhase() == 1 ? "La Línea" : "Estepona", secuenciador.getArrivedParties() + 1, secuenciador.getUnarrivedParties() - 1);
        secuenciador.arriveAndAwaitAdvance();
        try {
            Thread.sleep(rnd.nextInt(5000));
            System.out.printf("%s ha llegado a %s en el puesto %d y quedan %d por llegar%n", nombre, secuenciador.getPhase() == 1 ? "La Línea" : "Estepona", secuenciador.getArrivedParties() + 1, secuenciador.getUnarrivedParties() - 1);
            secuenciador.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
