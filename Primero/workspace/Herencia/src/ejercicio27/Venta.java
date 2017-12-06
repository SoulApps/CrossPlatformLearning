package ejercicio27;

/**
 * Created by Alejandro on 24/02/2016.
 */
public class Venta implements Cloneable {
    private int numVenta;
    private double importe;

    public Venta(int numVenta, double importe) {
        this.numVenta = numVenta;
        this.importe = importe;
    }


    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Object clone() {
        Venta v;

        try{
            v = (Venta) super.clone();
        } catch (CloneNotSupportedException e) {
            v = null;
        }

        return v;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof  Venta)
            if (numVenta == ((Venta) o).numVenta && importe == ((Venta) o).importe)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Número de venta: %d] [Importe: %.2f]", numVenta, importe);
    }
}
