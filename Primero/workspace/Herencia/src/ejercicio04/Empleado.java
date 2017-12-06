package ejercicio04;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Empleado {
    final double SUELDO_BASE = 1200;
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado() {
        nombre = "Sin nombre";
    }

    public double calcularSueldo() {
        return SUELDO_BASE;
    }

    public String toString() {
        return String.format("[Nombre: %s] [Sueldo: %2f]", nombre, calcularSueldo());
    }
}
