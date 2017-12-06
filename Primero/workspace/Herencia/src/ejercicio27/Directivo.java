package ejercicio27;

/**
 * Created by Alejandro on 24/02/2016.
 */
public abstract class Directivo extends Empleado {
    protected String descripcion;

    public Directivo(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
    }


    protected abstract void calcularSueldo();


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Empleado)
            if (nombre.equals(((Empleado) o).nombre) && sueldo == ((Empleado) o).sueldo)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Descripción: %s]", super.toString(), descripcion);
    }


}
