package paquete;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class ElVestiditos extends Thread {

    private Cesta origen;

    public ElVestiditos(Cesta origen) {
        this.origen = origen;
    }

    public void ponerVestido() {
        try {
            for (int i = 0; i < Main.NUM_MUNHECAS; i++) {
                origen.quitarMunheca();
                TimeUnit.SECONDS.sleep(Main.RND.nextInt(5) + 1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ponerVestido();
    }
}
