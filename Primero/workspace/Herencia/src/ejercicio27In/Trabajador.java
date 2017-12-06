package ejercicio27In;

/**
 * Created by Alejandro on 24/02/2016.
 */
public class Trabajador extends Empleado {

    public Trabajador(String nombre) {
        super(nombre);
    }


    protected void calcularSueldo() {
        sueldo = SUELDO_BASE;
    }
}
