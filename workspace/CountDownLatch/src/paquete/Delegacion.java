package paquete;

import java.util.Random;

/**
 * Created by Alejandro on 09/11/2016.
 */
public class Delegacion extends Thread {

    private Videoconferencia videoconferencia;
    private int participantes;
    private Random rnd;

    public Delegacion(Videoconferencia videoconferencia, int participantes) {
        this.videoconferencia = videoconferencia;
        this.participantes = participantes;
        rnd = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < participantes; i++) {
                videoconferencia.unirse();
                Thread.sleep(rnd.nextInt(5) * 1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
