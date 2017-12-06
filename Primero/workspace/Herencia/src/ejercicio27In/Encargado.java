package ejercicio27In;

/**
 * Created by Alejandro on 24/02/2016.
 */
public class Encargado extends Directivo {

    public Encargado(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public void calcularSueldo() {
        sueldo *= 1.20;
    }
}
