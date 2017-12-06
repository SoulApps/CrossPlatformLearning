package materiales;

import globalValues.GlobalValues;

/**
 * Clase que representa una ficha en el tablero.
 *
 *
 * Created by Alejandro on 08/04/2016.
 */
public class Ficha implements Cloneable {
    private boolean esBlanca;

    /**
     * Crea una ficha nueva.
     * @param esBlanca Determina el color de la ficha.
     */
    public Ficha(boolean esBlanca) {
        this.esBlanca = esBlanca;
    }

    /**
     * Dice de qu&eacute; color es la ficha.
     * @return Devuelve el valor booleano que representa el color de la ficha.
     */
    public boolean isEsBlanca() {
        return esBlanca;
    }


    /**
     * Cambia el valor booleano que representa el color de la ficha al contrario.
     */
    public void voltear() {
        if (esBlanca)
            esBlanca = false;
        else
            esBlanca = true;
    }

    /**
     * Clon.
     * @return Devuelve la ficha clonada.
     */
    public Object clone() {
        Ficha f;

        try {
            f = (Ficha) super.clone();
        } catch (CloneNotSupportedException e) {
            f = null;
        }

        return f;
    }

    /**
     * Equals.
     * @param o Es el otro objeto a comparar.
     * @return Devuelve un valor booleano dependiendo de su igualdad.
     */
    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Ficha)
            if (esBlanca == ((Ficha) o).esBlanca)
                igual = true;

        return igual;
    }

    /**
     * ToString.
     * @return Devuelve en una cadena el car&aacute;cter que la representa con su color correspondiente.
     */
    public String toString() {
        return String.format("%c", esBlanca?GlobalValues.FICHA_BLANCA:GlobalValues.FICHA_NEGRA);
    }
}
