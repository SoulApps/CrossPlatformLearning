package paquete;

import java.util.Random;

/**
 * Created by Alejandro on 18/10/2016.
 */
public class Consumidor extends Thread {
    private String nombre;
    private Bandeja bandeja;
    Random rnd;

    public Consumidor(String nombre, Bandeja bandeja) {
        this.nombre = nombre;
        this.bandeja = bandeja;
        rnd = new Random();
    }

    private void cogerDonut() {
        bandeja.cogerDonut(nombre);
    }

    private void esperar() {
        try {
            Thread.sleep(rnd.nextInt(3000) + 1000);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (true) {
            cogerDonut();
            esperar();
        }
    }
}
