package ejercicio14;

/**
 * Created by Alejandro on 04/02/2016.
 */
public abstract class Producto implements Mercancia {

    protected double precio;
    protected String descripcion;

    public Producto(double precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public double damePrecio() {
        return precio;
    }

    public String dameDescripcion() {
        return descripcion;
    }
}
