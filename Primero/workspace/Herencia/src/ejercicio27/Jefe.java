package ejercicio27;

/**
 * Created by Alejandro on 24/02/2016.
 */
public class Jefe extends Directivo {

    public Jefe(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public void calcularSueldo() {
        sueldo *= 1.20;
    }
}
