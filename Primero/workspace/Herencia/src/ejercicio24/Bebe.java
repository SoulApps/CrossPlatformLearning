package ejercicio24;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Bebe implements Bebito, Cloneable {
    private boolean dormido;
    private float peso;

    public Bebe(boolean dormido, float peso) {
        this.dormido = dormido;
        this.peso = peso;
    }


    public void dormir() {
        if (!dormido)
            dormido = true;
    }

    public void despertar() {
        if (dormido)
            dormido = false;
    }

    public void comer(float litros) {
        if (!dormido)
            peso += litros * 0.25;
    }

    public Object clone() {
        Bebe b;

        try {
            b = (Bebe) super.clone();
        } catch (CloneNotSupportedException e) {
            b = null;
        }
        return b;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Bebe)
            if (dormido == ((Bebe) o).dormido && peso == ((Bebe) o).peso)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Estado: %s] [Peso: %.2f]", dormido?"Dormido":"Despierto", peso);
    }
}
