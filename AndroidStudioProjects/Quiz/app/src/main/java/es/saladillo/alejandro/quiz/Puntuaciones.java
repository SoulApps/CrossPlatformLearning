package es.saladillo.alejandro.quiz;

import java.util.ArrayList;

/**
 * Created by Alejandro on 09/12/2016.
 */

public class Puntuaciones {

    private static ArrayList<Puntuacion> puntuaciones = new ArrayList<>();

    public static void add(Puntuacion puntuacion) {
        puntuaciones.add(puntuacion);
    }

    public static ArrayList<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }

}
