package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Monitor implements Cloneable {
    private String marcaMonitor;
    private int resolucion;

    protected Monitor(String marcaMonitor, int resolucion) {
        this.marcaMonitor = marcaMonitor;
        this.resolucion = resolucion;
    }

    public String getMarcaMonitor() {
        return marcaMonitor;
    }

    public void setMarcaMonitor(String marcaMonitor) {
        this.marcaMonitor = marcaMonitor;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Monitor)
            if (marcaMonitor.equals(((Monitor) o).marcaMonitor) && resolucion == ((Monitor) o).resolucion)
                igual = true;

        return igual;
    }

    public Object clone() {
        Monitor m;

        try {
            m = (Monitor) super.clone(); //LLamo al de Object
        } catch (CloneNotSupportedException e) {
            m = null;
        }

        return m;
    }

    public String toString() {
        return String.format("[Marca monitor: %s] [Resolucion: %d]", marcaMonitor, resolucion);
    }
}
