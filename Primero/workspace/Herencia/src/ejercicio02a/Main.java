package ejercicio02a;

/**
 * Created by Alejandro on 25/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        Padre p = new Padre();
        Hijo mismo = new Hijo();
        ejercicio02b.Hijo otro = new ejercicio02b.Hijo();

        System.out.println(p.protegidoPadre);
        System.out.println(p.protegidoPadre);
        System.out.println(p.publicoPadre);
        System.out.println(p.amigablePadre);

        //System.out.println(mismo.privadoPadre);
        System.out.println(mismo.protegidoHijoMismoPaquete);
        System.out.println(mismo.publicoHijoMismoPaquete);
        System.out.println(mismo.amigableHijoMismoPaquete);

        //System.out.println(otro.privadoHijoOtroPaquete);
        //System.out.println(otro.protegidoHijoOtroPaquete);
        System.out.println(otro.publicoHijoOtroPaquete);
       // System.out.println(otro.amigableHijoOtroPaquete);
    }
}
