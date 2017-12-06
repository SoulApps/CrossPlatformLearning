package paquete;

/**
 * Created by Alejandro on 26/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 9; i++)
            new Tabla(i).start();

        System.out.println("Terminé");
    }
}
