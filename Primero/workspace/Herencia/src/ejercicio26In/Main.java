package ejercicio26In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Loro l;
        Perro tobi, doge;
        Gato grumpy;

        l = new Loro("", 1, "", true, Alimentacion.INSECTIVORA, false);
        System.out.println(l.hablar());
        System.out.println(l);

        tobi = new Perro("Tobi", 1, "", true, "", Agresividad.ALTO);
        System.out.println(tobi);
        doge = new Perro("Doge", 1, "", true, "", Agresividad.ALTO);
        System.out.println(doge);
        grumpy = new Gato("Grumpy", 2, "", false, "");
        System.out.println(grumpy);
    }
}
