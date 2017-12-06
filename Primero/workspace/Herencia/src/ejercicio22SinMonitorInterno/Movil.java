package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Movil extends Dispositivo {
    private boolean es4G;

    public Movil(String marca, String modelo, int stock, int capacidad, boolean es4G) {
        super(marca, modelo, stock, capacidad);
        this.es4G = es4G;
    }

    public boolean isEs4G() {
        return es4G;
    }

    public void setEs4G(boolean es4G) {
        this.es4G = es4G;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Movil)
            if (super.equals(o) && es4G == ((Movil) o).es4G)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Tecnología: %s]", super.toString(), es4G?"4G":"3G");
    }
}
