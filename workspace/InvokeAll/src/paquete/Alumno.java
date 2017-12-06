package paquete;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Alumno implements Callable<Entrega> {

    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Entrega call() throws Exception {
        TimeUnit.SECONDS.sleep(new Random().nextInt(2));
        return new Entrega(this, new Random().nextInt(100));
    }

    @Override
    public String toString() {
        return String.format("[Alumno: %s]", nombre);
    }
}
