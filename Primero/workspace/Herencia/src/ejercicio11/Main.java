package ejercicio11;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Dado d = new Dado();
        Moneda m = new Moneda();
        System.out.println(d.lanzar());
        System.out.println(m.lanzar(m.lanzar()));

    }
}
