package clases;

import java.util.Date;

/**
 * Created by Alejandro on 16/02/2017.
 */
public class Ventas {
    int codventa;
    Articulos codarti;
    Clientes numcli;
    int univen;
    Date fecha;

    Ventas(int codventa, Articulos codarti, Clientes numcli, int univen, Date fecha) {
        this.codventa = codventa;
        this.codarti = codarti;
        this.numcli = numcli;
        this.univen = univen;
        this.fecha = fecha;
    }

    public String toString() {
        return "Ventas{" +
                "codventa=" + codventa +
                ", codarti=" + codarti +
                ", numcli=" + numcli +
                ", univen=" + univen +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
