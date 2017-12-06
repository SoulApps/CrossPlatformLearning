package ejercicio08;

/**
 * Created by Alejandro on 15/01/2016.
 */
public class Producto {
    private String modelo;
    private Procesador procesador;
    private int stock;
    private float precio;


    public Producto(String modelo, Procesador procesador, int stock, float precio) throws Exception {
        setModelo(modelo);
        this.procesador = procesador;
        setStock(stock);
        setPrecio(precio);
    }

    public Producto() throws Exception {
        this("000-NNNN", Procesador.INTEL, 0, 0);
    }

    /*
    String getModelo() {
        return modelo;
    }
    */

    //Uso el público para el sorteo
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) throws Exception {
        if (!modelo.matches("[1-9]{3}-[A-ZÑ]{4}"))
            throw new Exception("Modelo incorrecto");
        else
            this.modelo = modelo;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    public void setStock(int stock) throws Exception {
        if (stock < 0)
            throw new Exception("Stock incorrecto");
        else
            this.stock = stock;
    }
    public int getStock() {
        return stock;
    }

    public void setPrecio(float precio) throws Exception {
        if (precio < 0)
            throw new Exception("Precio incorrecto");
        else
            this.precio = precio;
    }

    public void disminuirStock() {
        if (stock > 0)
            stock--;
        stock = stock > 0 ? stock-- : 0;
    }

    public String toString() {
        return String.format("Modelo: %s%nStock: %d%nProcesador %s%nPrecio: %.2f%n", modelo, stock, procesador, precio);
    }
}
