package es.saladillo.alejandro.sqlite.db.models;

/**
 * Created by Alejandro on 04/02/2017.
 */

public class Alumno {

    private long id;
    private String nombre;
    private int edad;

    // Constructores.
    public Alumno(long id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public Alumno() {}

    // Getters y Setters.
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    // Útil para ArrayAdapters.
    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
