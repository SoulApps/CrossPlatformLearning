package ejercicio16;

/**
 * Created by Alejandro on 15/02/2016.
 */
public class Pez implements Cloneable {

    protected String nombre;

    public Pez(String nombre) {
        this.nombre = nombre;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Pez)
            if (nombre.equals(((Pez) o).nombre))
                igual = true;

        return igual;
    }

    public Object clone() {
        Pez p;
        try {
            p = (Pez) super.clone();
        } catch (CloneNotSupportedException e) {
            p = null;
        }
        return p;
    }

    public String toString() {
        return String.format("Nombre: %s", nombre);
    }
}
