package ejercicio26;

/**
 * Created by Alejandro on 23/02/2016.
 */
public abstract class Ave extends Animal {
    Alimentacion alimentacion;

    public Ave(String nombre, double cuota, String raza, boolean enfadado, Alimentacion alimentacion) {
        super(nombre, cuota, raza, enfadado);
        this.alimentacion = alimentacion;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Ave)
            if (nombre.equals(((Animal) o).nombre) && cuota == ((Animal) o).cuota && raza.equals(((Animal) o).raza))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Alimentación: %s]", super.toString(), alimentacion);
    }
}
