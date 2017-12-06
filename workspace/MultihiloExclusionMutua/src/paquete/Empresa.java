package paquete;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 03/10/2016.
 */
public class Empresa implements Runnable {

    public Empresa(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    private Cuenta cuenta;

    @Override
    public void run() {
        cuenta.ingresar(5);
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3) + 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Se ha ingresado 5");
    }
}
