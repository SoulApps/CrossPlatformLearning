package ejercicio17;

/**
 * Created by Alejandro on 15/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        Pez p1, p2;
        p1 = new Pez("Pececito");
        //System.out.println(p1.numPeces);
        //p2 = new Pez("pegacao");
        //System.out.println(p2.numPeces);
        p2 = (Pez) p1.clone();

        System.out.println(p1.equals(p2));
    }
}
