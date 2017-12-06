package paquete;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 25/10/2016.
 */
public class Tienda extends Thread {

    private Producto producto;
    private Random rnd;

    public Tienda(Producto producto) {
        this.producto = producto;
        rnd = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(rnd.nextInt(5) + 1);
                producto.cambiarPrecio();
            } catch (InterruptedException e) {

            }
        }
    }
}
