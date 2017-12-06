package es.saladillo.alejandro.swiperefreshlayout.models;

/**
 * Created by Alejandro on 30/01/2017.
 */

public class Alumno {

    private String nombre;
    private int edad;

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
