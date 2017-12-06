package ejercicio24In;

/**
 * Created by Alejandro on 22/02/2016.
 */
public abstract class Juguete extends Sorpresa {
    protected String color;

    protected Juguete(String nombre, String color) throws NombreIncorrectoException {
        super(nombre);
        this.color = color;
    }

    protected abstract float calcuarValorEconomico();


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Juguete)
            if (super.equals(o) && color.equals(((Juguete) o).color))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Color: %s]", super.toString(), color);
    }
}
