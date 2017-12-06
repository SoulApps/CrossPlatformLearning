package ejercicio14;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Producto a = new Alfareria(2, "Alfo", false);
        Producto p = new Planta(1, "\"Hierbas medicinales\"", true);

        dameDatos(a);
        dameDatos(p);

    }

    public static void dameDatos(Mercancia producto) {
        System.out.printf("[Precio: %f] [Descripción: %s]%n", producto.damePrecio(), producto.dameDescripcion());
    }
}
