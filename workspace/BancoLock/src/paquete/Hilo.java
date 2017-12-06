package paquete;

/**
 * Created by Alejandro on 24/10/2016.
 */
public class Hilo extends Thread {

    private Cuenta cuenta;

    public Hilo(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++)
            cuenta.incrementarSaldo();
    }
}
