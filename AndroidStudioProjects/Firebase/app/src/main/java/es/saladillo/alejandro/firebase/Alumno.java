package es.saladillo.alejandro.firebase;

/**
 * Created by Alejandro on 07/03/2017.
 */

public class Alumno {

    private String clave;
    private String nombre;
    private int edad;

    public Alumno() {
    }

    public Alumno(String clave, String nombre, int edad) {
        this.clave = clave;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
