package ejercicio01;

import teclado.Teclado;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class Persona {
    private String nombre;
    private int edad;
    private float altura;
    private String ocupacion;
    private float sueldo;

    public Persona() {
        this("Sin nombre", 0, 0.0f, "Sin ocupación");
    }

    public Persona(String nombre, int edad, float altura, String ocupacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.ocupacion = ocupacion;
    }


    String getNombre(){
        return nombre;
    }
    void setNombre(String nombre){
        this.nombre=nombre;
    }

    int getEdad() {
        return edad;
    }
    void setEdad(int edad) {
        this.edad = edad;
    }

    float getAltura() {
        return altura;
    }
    void setAltura(float altura) {
        this.altura = altura;
    }

    String getOcupacion() {
        return ocupacion;
    }
    void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public void sumarSueldo(Persona p) { setSueldo(this.sueldo + p.getSueldo()); }

    public void doblarSueldo() {
        sumarSueldo(this);
    }
}
