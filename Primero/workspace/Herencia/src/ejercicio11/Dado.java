package ejercicio11;

import java.util.Random;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Dado extends Sorteo {

    public Dado() {
        posibilidades = 6;
    }

    public int lanzar() {
        Random rnd = new Random();
        return rnd.nextInt(posibilidades) + 1;
    }
}
