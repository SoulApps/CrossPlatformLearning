package ejercicio24In;

/**
 * Created by Alejandro on 22/02/2016.
 */
public abstract class Sorpresa implements Cloneable {
    protected String nombre;

    protected Sorpresa(String nombre) throws NombreIncorrectoException {
        setNombre(nombre);
    }
    protected void setNombre(String nombre) throws NombreIncorrectoException {
        if (nombre.matches("[A-Za-zÑñÁÉÍÓÚáéíóú]+"))
            this.nombre = nombre;
        else
            throw new NombreIncorrectoException("¡ERROR! ¡Nombre incorrecto!");
    }

    public String getNombre() {
        return nombre;
    }

    protected Object clone() {
        Sorpresa s;

        try {
            s = (Sorpresa) super.clone();
        } catch (CloneNotSupportedException e) {
            s = null;
        }

        return s;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Sorpresa)
            if (nombre.equals(((Sorpresa) o).nombre))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Nombre: %s]", nombre);
    }
}
