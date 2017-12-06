package paquete;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 03/10/2016.
 */
public class Banco implements Runnable {

    private Cuenta cuenta;

    public Banco(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        cuenta.cargar(10);
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3) + 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Se ha retirado 10");
    }
}
