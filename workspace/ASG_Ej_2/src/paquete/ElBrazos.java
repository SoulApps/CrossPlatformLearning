package paquete;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 14/12/2016.
 */
public class ElBrazos extends Thread {

    private Cesta origen;
    private Cesta destino;

    public ElBrazos(Cesta origen, Cesta destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public void ponerBrazos() {
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
        ponerBrazos();
    }
}
