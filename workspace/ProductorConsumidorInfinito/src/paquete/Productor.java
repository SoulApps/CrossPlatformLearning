package paquete;

import java.util.Random;

/**
 * Created by Alejandro on 18/10/2016.
 */
public class Productor extends Thread {
    private String nombre;
    private Bandeja bandeja;
    private Random rnd;

    public Productor(String nombre, Bandeja bandeja) {
        this.nombre = nombre;
        this.bandeja = bandeja;
        rnd = new Random();
    }

    private void anhadirDonut() {
        bandeja.anhadirDonut(nombre);
    }

    private void esperar() {
        try {
            Thread.sleep(rnd.nextInt(2000) + 1000);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (true) {
            anhadirDonut();
            esperar();
        }
    }
}
