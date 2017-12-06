package paquete;

/**
 * Created by Alejandro on 25/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Producto producto = new Producto();
        Tienda tienda = new Tienda(producto);
        Cliente cliente[] = new Cliente[5];

        tienda.start();

        for (i = 0; i < 5; i++)
            cliente[i] = new Cliente(producto);

        for (i = 0; i < 5; i++)
            cliente[i].start();

    }
}
