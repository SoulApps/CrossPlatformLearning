package ejercicio22SinMonitorInterno;

/**
 * Created by Alejandro on 17/02/2016.
 */
public class Producto implements Cloneable {
    protected String marca;
    protected String modelo;
    protected int stock;

    protected Producto(String marca, String modelo, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
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
            if (marca.equals(((Producto) o).marca) && modelo.equals(((Producto) o).modelo) && stock == ((Producto) o).stock)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Marca: %s] [Modelo: %s] [Stock: %d]", marca, modelo, stock);
    }
}
