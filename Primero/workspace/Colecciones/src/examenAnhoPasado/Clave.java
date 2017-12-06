package examenAnhoPasado;

/**
 * Created by Alejandro on 09/05/2016.
 */
public class Clave implements Cloneable {
    private EnumCategoria categoria;
    private int numero;

    public Clave(EnumCategoria categoria, int numero) {
        this.categoria = categoria;
        this.numero = numero;
    }


    public EnumCategoria getCategoria() {
        return categoria;
    }
    public int getNumero() {
        return  numero;
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
            if (categoria  == (((Clave) o).categoria) && numero == ((Clave) o).numero)
                igual = true;

        return igual;
    }

    public int hashCode() {
        return categoria.hashCode() + numero;
    }

    public String toString() {
        return String.format("%c%d", categoria.getCodigo(), numero);
    }
}
