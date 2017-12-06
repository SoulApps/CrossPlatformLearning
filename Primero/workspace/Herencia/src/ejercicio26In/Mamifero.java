package ejercicio26In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public abstract class Mamifero extends Animal {
    protected String champu;

    public Mamifero(String nombre, double cuota, String raza, boolean enfadado, String champu) {
        super(nombre, cuota, raza, enfadado);
        this.champu = champu;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Mamifero)
            if (super.equals(o) && champu.equals(((Mamifero) o).champu))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Champú: %s]", super.toString(), champu);
    }
}
