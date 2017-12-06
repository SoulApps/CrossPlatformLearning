package ejercicio04;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Encargado extends Empleado {

    public Encargado(String nombre) {
        super(nombre);
    }

    public double calcularSueldo() {
        return super.calcularSueldo() * 1.1;
    }
}
