package ejercicio16;

/**
 * Created by Alejandro on 15/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Pez p1 = new Pez("Pececito");
        Pez p2 = new Pez("pegacao");
        System.out.println(p1);
        //p2 = (Pez) p1.clone();
        System.out.println(p2);
        System.out.println(p1.equals(p2));
    }
}
