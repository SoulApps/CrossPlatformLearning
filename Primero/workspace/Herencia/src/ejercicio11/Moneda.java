package ejercicio11;

import java.util.Random;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Moneda extends Sorteo {

    public Moneda() {
        posibilidades = 2;
    }

    public int lanzar() {
        Random rnd = new Random();
        return rnd.nextInt(posibilidades);
    }

    public String lanzar(int n) {
        /*String moneda;
        if (n == 1)
            moneda = "Cara";
        else
            moneda = "Cruz";
        return moneda;*/
        return n == 1?"Cara":"Cruz";
    }
}
