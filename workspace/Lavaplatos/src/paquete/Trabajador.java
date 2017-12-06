package paquete;

/**
 * Created by Alejandro on 10/10/2016.
 */
public abstract class Trabajador implements Runnable {

    String nombre;

    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

}
