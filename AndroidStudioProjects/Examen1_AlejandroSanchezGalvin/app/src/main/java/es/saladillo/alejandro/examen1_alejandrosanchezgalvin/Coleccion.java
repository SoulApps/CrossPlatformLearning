package es.saladillo.alejandro.examen1_alejandrosanchezgalvin;

import java.util.ArrayList;

/**
 * Created by Alejandro on 13/12/2016.
 */

public class Coleccion {

    private static ArrayList<Personaje> lista = new ArrayList<>();

    public static void addPersonaje(Personaje p) {
        lista.add(p);
    }

    public static void removePersonaje(Personaje p) {
        lista.remove(p);
    }

    public static ArrayList<Personaje> getLista() {
        return lista;
    }
}
