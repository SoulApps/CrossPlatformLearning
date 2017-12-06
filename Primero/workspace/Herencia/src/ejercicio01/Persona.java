package ejercicio01;

/**
 * Created by Alejandro on 19/01/2016.
 */
public class Persona {
    protected String nombre;
    protected byte edad;
    protected Sexo sexo;
    protected String nacionalidad;

    //Constructor por defecto
    public Persona() {
        this("Sin nombre", (byte) 0, Sexo.HOMBRE, "Ninguna");
    }

    public Persona(String nombre, byte edad, Sexo sexo, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }

    public String toString() {
        return String.format("[Nombre: %s] [Edad: %d] [Sexo: %s] [Nacinalidad: %s]", nombre, edad, sexo, nacionalidad);
    }
}
