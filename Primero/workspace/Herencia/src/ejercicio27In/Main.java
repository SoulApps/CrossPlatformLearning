package ejercicio27In;

/**
 * Created by Alejandro on 02/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        Trabajador t = new Trabajador("Pepe");
        Trabajador tclone;

        t.ventaRealizada(1, 2);
        System.out.println(t);
        t.ventaRealizada(2, 2);
        t.ventaRealizada(2, 2);
        System.out.println(t);

        tclone = (Trabajador) t.clone();
        System.out.println(tclone.equals(t));
    }
}
