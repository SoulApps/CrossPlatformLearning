package ejercicio25In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public abstract class Vehiculo implements Cloneable {
    protected String matricula;
    protected Marca marca;

    protected Vehiculo(String matricula, Marca marca) {
        this.matricula = matricula;
        this.marca = marca;
    }


    public int calcularNumRuedas() {
        int numRuedas;

        if (this instanceof Triciclo)
            numRuedas = 3;
        else if (this instanceof Coche)
            numRuedas = 4;
        else
            numRuedas = 2;

        return numRuedas;
    }


    public Object clone() {
        Vehiculo v;

        try {
            v = (Vehiculo) super.clone();
        } catch (CloneNotSupportedException e) {
            v = null;
        }

        return v;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Vehiculo)
            if (matricula.equals(((Vehiculo) o).matricula) && marca.equals(((Vehiculo) o).marca))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Matrícula: %s] [Marca: %s]", matricula, marca);
    }
}
