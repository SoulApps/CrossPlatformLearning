package AlejandroSanchezGalvin;

/**
 * Created by Alejandro on 13/05/2016.
 */
public class Clave implements Cloneable {
    private Genero genero;
    private int numero;

    public Clave(Genero genero, int numero) {
        this.genero = genero;
        this.numero = numero;
    }


    public Genero getGenero() {
        return genero;
    }

    public int getNumero() {
        return numero;
    }


    public Object clone() {
        Clave c;

        try {
            c = (Clave) super.clone();
        } catch (CloneNotSupportedException e) {
            c = null;
        }

        return c;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Clave)
            if (genero == ((Clave) o).genero && numero == ((Clave) o).numero)
                igual = true;

        return igual;
    }

    public int hashCode() {
        return genero.hashCode() + numero;
    }


    public String toString() {
        return String.format("%c%d", genero.getCodigo(), numero);
    }
}
