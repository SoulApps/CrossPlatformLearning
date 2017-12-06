package paquete;

/**
 * Created by Alejandro on 18/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja();
        Productor productor1 = new Productor("Productor1", bandeja);
        Productor productor2 = new Productor("Productor2", bandeja);
        Productor productor3 = new Productor("Productor3", bandeja);
        Consumidor consumidor1 = new Consumidor("Consumidor1", bandeja);
        Consumidor consumidor2 = new Consumidor("Consumidor2", bandeja);
        Consumidor consumidor3 = new Consumidor("Consumidor3", bandeja);

        productor1.start();
        productor2.start();
        productor3.start();
        consumidor1.start();
        consumidor2.start();
        consumidor3.start();
    }
}
