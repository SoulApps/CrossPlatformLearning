package paquete;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Alejandro on 09/11/2016.
 */
public class Videoconferencia extends Thread {

    private int asistentes;
    private CountDownLatch cont;

    public Videoconferencia(int asistentes) {
        this.asistentes = asistentes;
        cont = new CountDownLatch(asistentes);
    }

    public void unirse() {
        cont.countDown();
        if (cont.getCount() != 0)
            System.out.printf("Faltan %d personas%n", cont.getCount());
    }

    @Override
    public void run() {
        try {
            System.out.println("Esperando a los asistentes");
            cont.await();
            System.out.println("Ya están todos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
