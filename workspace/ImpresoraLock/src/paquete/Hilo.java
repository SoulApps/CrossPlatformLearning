package paquete;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Hilo implements Runnable {

    private Impresora impresora;

    public Hilo(Impresora impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {
        impresora.imprimir();
    }
}
