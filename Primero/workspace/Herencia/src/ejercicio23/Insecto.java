package ejercicio23;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Insecto implements Cloneable, Insectable {
    private static int insectosCreados = 0;

    private String color;
    private short numPatas;
    private float peso;

    public Insecto(String color, short numPatas, float peso) {
        this.color = color;
        this.numPatas = numPatas;
        this.peso = peso;
        insectosCreados++;
    }


    public static int getInsectosCreados() {
        return insectosCreados;
    }


    public void nutrir(float gramosComida) {
        peso += gramosComida / 2;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public short getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(short numPatas) {
        this.numPatas = numPatas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public Object clone() {
        Insecto i;

        try {
            i = (Insecto) super.clone();
        } catch (CloneNotSupportedException e) {
            i = null;
        }

        return i;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Insecto)
            if (color.equals(((Insecto) o).color) && numPatas == ((Insecto) o).numPatas && peso == ((Insecto) o).peso)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Color: %s] [NumPatas = %d] [PesoGr : %.3f]", color, numPatas, peso);
    }
}
