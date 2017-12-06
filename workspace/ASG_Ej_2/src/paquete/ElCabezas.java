package paquete;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class ElCabezas extends Thread {

    private Cesta destino;

    public ElCabezas(Cesta destino) {
        this.destino = destino;
    }

    public void ponerCabeza() {
        try {
            for (int i = 0; i < Main.NUM_MUNHECAS; i++) {
                TimeUnit.SECONDS.sleep(Main.RND.nextInt(5) + 1);
                destino.anhadirMunheca();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ponerCabeza();
    }
}
