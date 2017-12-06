package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Dispositivo extends Producto {
    protected int capacidad;

    protected Dispositivo(String marca, String modelo, int stock, int capacidad) {
        super(marca, modelo, stock);
        this.capacidad = capacidad;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Dispositivo)
            if (super.equals(o) && capacidad == ((Dispositivo)o).capacidad)
                igual = true;

        return igual;
    }


    public String toString() {
        return String.format("%s [Capacidad de memoria: %d GiB]", super.toString(), capacidad);
    }
}
