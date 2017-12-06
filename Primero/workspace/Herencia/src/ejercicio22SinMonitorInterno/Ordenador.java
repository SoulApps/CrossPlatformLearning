package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Ordenador extends Producto {
    protected double procesador;
    protected int hdd;

    protected Ordenador(String marca, String modelo, int stock, double procesador, int hdd) {
        super(marca, modelo, stock);
        this.procesador = procesador;
        this.hdd = hdd;
    }


    public double getProcesador() {
        return procesador;
    }

    public void setProcesador(double procesador) {
        this.procesador = procesador;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Ordenador)
            if (super.equals(o) && procesador == ((Ordenador) o).procesador && hdd == ((Ordenador) o).hdd)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Velocidad del procesador: %.2f] [Capacidad: %d GiB]",super.toString(), procesador, hdd);
    }
}
