package ejercicio22;

/**
 * Created by Alejandro on 17/02/2016.
 */
public abstract class Ordenador extends Producto {
    protected double procesador;
    protected int hdd;

    protected Ordenador(String marca, String modelo, int stock, double procesador, int hdd) {
        super(marca, modelo, stock);
        this.procesador = procesador;
        this.hdd = hdd;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Ordenador)
            if (super.equals(o))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Velocidad del procesador: %.2f] [Capacidad: %d GiB]",super.toString(), procesador, hdd);
    }
}
