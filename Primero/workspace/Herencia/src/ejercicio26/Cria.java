package ejercicio26;

/**
 * Created by Alejandro on 04/03/2016.
 */
public class Cria implements Cloneable {
    private String nombre;

    public Cria(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Object clone() {
        Cria c;

        try {
            c = (Cria) super.clone();
        } catch (CloneNotSupportedException e) {
            c = null;
        }

        return c;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Cria)
            if (nombre.equals(((Cria) o).nombre))
                igual = true;

        return igual;
    }


    public String toString() {
        return String.format("[Nombre: %s]", nombre);
    }
}
