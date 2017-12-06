package paquete;

import java.util.Random;

/**
 * Created by Alejandro on 17/10/2016.
 */
public class Filosofo implements Runnable {
    private int n;
    private Palillo palilloL;
    private Palillo palilloR;
    private Random rnd;

    public Filosofo(int n, Palillo palilloL, Palillo palilloR) {
        this.n = n;
        this.palilloL = palilloL;
        this.palilloR = palilloR;
        rnd = new Random();
    }

    private void cogerPalL() {
        palilloL.cogerPalillo(n);
    }

    private void cogerPalR() {
        palilloR.cogerPalillo(n);
    }

    private void soltarPalL() {
        palilloL.soltarPalillo(n);
    }

    private void soltarPalR() {
        palilloR.soltarPalillo(n);
    }

    private void comer() {
        if (n % 2 == 0) {
            cogerPalL();
            cogerPalR();
        } else {
            cogerPalR();
            cogerPalL();
        }
        alimentarse();
        soltarPalL();
        soltarPalR();
    }

    private void alimentarse() {
        try {
            System.out.printf("El filósofo %d está comiendo%n", n);
            Thread.sleep(rnd.nextInt(3000) + 1000);
        } catch (InterruptedException e) {

        }
    }

    private void pensar() {
        try {
            System.out.printf("El filósofo %d está pensando%n", n);
            Thread.sleep(rnd.nextInt(3000) + 1000);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (true) {
            comer();
            pensar();
        }
    }
}
