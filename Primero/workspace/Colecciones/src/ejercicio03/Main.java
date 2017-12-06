package ejercicio03;

import java.util.ArrayList;

/**
 * Created by Alejandro on 23/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        long suma = 0;
        ArrayList<Caja<String>> cadenas = new ArrayList<Caja<String>>();
        ArrayList<Caja<Long>> longs = new ArrayList<Caja<Long>>();

        //Guardar cadenas.
        cadenas.add(new Caja("Caja 1"));
        cadenas.add(new Caja("Caja 2"));
        cadenas.add(new Caja("Caja 3"));
        cadenas.add(new Caja("Caja 4"));
        cadenas.add(new Caja("Caja 5"));
        cadenas.add(new Caja("Caja 6"));
        cadenas.add(new Caja("Caja 7"));
        cadenas.add(new Caja("Caja 8"));
        cadenas.add(new Caja("Caja 9"));
        cadenas.add(new Caja("Caja 10"));

        //Mostrar contenido.
        System.out.println("Cadenas");
        for (Caja c:cadenas)
            System.out.println(c.getContenido());

        //Guardar longs.
        longs.add(new Caja(1L));
        longs.add(new Caja(2L));
        longs.add(new Caja(3L));
        longs.add(new Caja(4L));
        longs.add(new Caja(5L));
        longs.add(new Caja(6L));
        longs.add(new Caja(7L));
        longs.add(new Caja(8L));
        longs.add(new Caja(9L));
        longs.add(new Caja(10L));

        //Mostrar longs.
        System.out.println("\n\nLongs");
        for (Caja c:longs) {
            suma += (Long) c.getContenido();
            System.out.println(c.getContenido());
        }
        System.out.printf("Suma: %d", suma);

    }
}
