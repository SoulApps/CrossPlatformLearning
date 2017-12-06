package ejercicio22;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Sobremesa extends Ordenador {

    Monitor monitor;

    public Sobremesa(String marca, String modelo, int stock, double procesador, int hdd, String marcaMonitor, int resolucion) {
        super(marca, modelo, stock, procesador, hdd);
        monitor = new Monitor(marcaMonitor, resolucion);
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Ordenador)
            if (super.equals(o) && monitor.equals(((Sobremesa)o).monitor))
                igual = true;

        return igual;
    }


    public Object clone() {
        Sobremesa s;
        s = (Sobremesa) super.clone();
        s.monitor = (Monitor) monitor.clone();
        return s;
    }

    public String toString() {
        return String.format("%s %s", super.toString(), monitor);
    }

    public class Monitor implements Cloneable {

        private String marca;
        private int resolucion;

        private Monitor(String marca, int resolucion) {
            this.marca = marca;
            this.resolucion = resolucion;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public boolean equals(Object o) {
            boolean igual = false;

            if (o instanceof Monitor)
                if (marca.equals(((Monitor) o).marca) && resolucion == ((Monitor) o).resolucion)
                    igual = true;

            return igual;
        }

        public Object clone() {
            Monitor m;
            try {

                m = (Monitor) super.clone();
            } catch (CloneNotSupportedException e) {
                m = null;
            }

            return m;
        }

        public String toString() {
            return String.format("[Marca monitor: %s] [Resolucion: %d]", marca, resolucion);
        }
    }
}
