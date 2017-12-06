package ejercicio14;

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
        return "Agenda{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", fechaNacimiento=" + fechaNacimiento +
                ", leDebo=" + leDebo +
                ", deuda=" + deuda +
                '}';
    }
}
