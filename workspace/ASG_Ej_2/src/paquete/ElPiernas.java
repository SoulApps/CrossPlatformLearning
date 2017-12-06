package paquete;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class ElPiernas extends Thread {

    private Cesta origen;
    private Cesta destino;

    public ElPiernas(Cesta origen, Cesta destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public void ponerPiernas() {
        try {
            for (int i = 0; i < Main.NUM_MUNHECAS; i++) {
                origen.quitarMunheca();
                TimeUnit.SECONDS.sleep(Main.RND.nextInt(5) + 1);
                destino.anhadirMunheca();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ponerPiernas();
    }
}
