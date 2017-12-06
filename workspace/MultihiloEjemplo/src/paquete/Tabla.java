package paquete;

/**
 * Created by Alejandro on 21/09/2016.
 */
public class Tabla extends Thread {

    private int numero;

    public Tabla(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        int i;
        for (i = 1; i <= 10; i++)
            System.out.printf("%s: %d x %d = %d%n", getName(), numero, i, numero * i);
    }
}
