package ejercicio25;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Motor implements Cloneable {
    private int cilindrada;
    private int caballos;

    public Motor(int cilindrada, int caballos) {
        this.cilindrada = cilindrada;
        this.caballos = caballos;
    }


    public Object clone() {
        Motor m;

        try {
            m = (Motor) super.clone();
        } catch (CloneNotSupportedException e) {
            m = null;
        }

        return m;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Motor)
            if (cilindrada == ((Motor) o).cilindrada && caballos == ((Motor) o).caballos)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Cilindrada: %d] [Caballos: %d]", cilindrada, caballos);
    }
}
