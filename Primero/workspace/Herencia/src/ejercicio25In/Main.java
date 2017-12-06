package ejercicio25In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Coche c1, c2, c1clon;
        c1 = new Coche("0001 COC", Marca.GLOBE, 1, 2);
        c2 = new Coche("0001 COC", Marca.SKIPE, 1, 2);
        c1clon = (Coche) c1.clone();
        //c1clon.arrancar();
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c1clon));
        System.out.println(c1clon);

    }
}
