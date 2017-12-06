package ejercicio17;

/**
 * Created by Alejandro on 15/02/2016.
 */
public class Pez implements Cloneable {

    protected static int numPeces = 0;
    protected String nombre;

    public Pez(String nombre) {
        this.nombre = nombre;
        numPeces++;
        if (numPeces == 1)
            System.out.printf("Hay %d pez en el mar%n", numPeces);
        else
            System.out.printf("Hay %d peces en el mar%n", numPeces);
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Pez) {
            if (nombre.equals(((Pez) o).nombre))
                igual = true;
            else
                igual = false;
        }

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
