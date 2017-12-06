package ejercicio15;

import java.io.Serializable;

/**
 * Created by Alejandro on 10/10/2016.
 */
public class Agenda implements Serializable {
    private String nombre;
    private String telefono;
    private String direccion;
    private int codigoPostal;
    private String fechaNacimiento;
    private boolean leDebo;
    private float deuda;

    public Agenda(String nombre, String telefono, String direccion, int codigoPostal, String fechaNacimiento, boolean leDebo, float deuda) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.fechaNacimiento = fechaNacimiento;
        this.leDebo = leDebo;
        this.deuda = deuda;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isLeDebo() {
        return leDebo;
    }

    public float getDeuda() {
        return deuda;
    }

    @Override
    public String toString() {
        return String.format("\tNombre: %21s%n\tTeléfono: %20s%n\tDirección: %25s%n\tCódigo postal: %11d%n\tFecha de nacimiento: %s%n\tLe debo dinero: %7s%n\tCuánto: %17.2f", nombre, telefono, direccion, codigoPostal, fechaNacimiento, leDebo?"Sí":"No", deuda);
    }
}
