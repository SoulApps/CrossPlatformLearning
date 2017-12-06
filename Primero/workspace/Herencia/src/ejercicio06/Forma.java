package ejercicio06;

import javax.swing.*;

/**
 * Created by Alejandro on 04/02/2016.
 */
public abstract class Forma {

    public abstract String toString();

    /*public String identidad() {
        return String.valueOf(getClass().getSimpleName());
    }*/

    /*public String identidad() {
        String forma = "";

        if (this instanceof Circulo)
            forma = "Circulo";
        else if (this instanceof Cuadrado)
            forma = "Cuadrado";
        else if (this instanceof Rombo)
            forma = "Rombo";
        else if (this instanceof Triangulo)
            forma = "Triángulo";

        return forma;
    }*/

    public String identidad() {
        return toString();
    }
}
