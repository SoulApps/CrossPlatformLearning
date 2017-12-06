package ejercicio22;

/**
 * Created by Alejandro on 17/02/2016.
 */
public abstract class Producto implements Cloneable {
    protected String marca;
    protected String modelo;
    protected int stock;

    protected Producto(String marca, String modelo, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
    }

    public Object clone() {
        Producto p;
        try {
            p = (Producto) super.clone();
        } catch (CloneNotSupportedException e) {
            p = null;
        }
        return p;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Producto)
            if (marca == ((Producto) o).marca && modelo == ((Producto) o).modelo && stock == ((Producto) o).stock)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Marca: %s] [Modelo: %s] [Stock: %d]", marca, modelo, stock);
    }
}
