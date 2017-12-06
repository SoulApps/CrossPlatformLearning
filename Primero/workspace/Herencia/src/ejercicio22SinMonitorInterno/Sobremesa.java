package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Sobremesa extends Ordenador {
    private Monitor monitor;

    public Sobremesa(String marca, String modelo, int stock, double procesador, int hdd, String marcaMonitor, int resolucion) {
        super(marca, modelo, stock, procesador, hdd);
        monitor = new Monitor(marcaMonitor, resolucion); //Clase interna
    }

    public Sobremesa(String marca, String modelo, int stock, double procesador, int hdd, Monitor monitor) {
        super(marca, modelo, stock, procesador, hdd);
        this.monitor = monitor; //Clase externa
    }

    public Monitor getMonitor() {
        return monitor;
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
        s = (Sobremesa) super.clone(); //Con super llamo al clone() de Ordenador
        s.monitor = (Monitor) monitor.clone();
        return s;
    }

    public String toString() {
        return String.format("%s %s", super.toString(), monitor);
    }

}
