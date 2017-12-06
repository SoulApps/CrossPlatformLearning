package paquete;

/**
 * Created by Alejandro on 10/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        Pila fregados = new Pila("Pila sucios");
        Pila secados = new Pila("Pila limpios");

        Thread luis = new Thread(new Luis("Luis", fregados));
        Thread pepe = new Thread(new Pepe("Pepe", fregados, secados));
        Thread juan = new Thread(new Juan("Juan", secados));

        luis.start();
        pepe.start();
        juan.start();

    }
}
