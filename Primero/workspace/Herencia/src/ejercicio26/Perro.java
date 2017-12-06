package ejercicio26;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Perro extends Mamifero {
    private static int numero = 001;
    private final char LETRA = 'P';
    private final String GRITO = "MUCH WOW, SO DOGE, MANY PROGRAMACIÓN";
    private Agresividad agresividad;

    public Perro(String nombre, double cuota, String raza, boolean enfadado, String champu, Agresividad agresividad) {
        super(nombre, cuota, raza, enfadado, champu);
        this.agresividad = agresividad;
        codigo = LETRA + String.valueOf(numero);
        numero++;
    }


    public String hablar() {
        return GRITO;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Perro)
            if (super.equals(o) && agresividad.equals(((Perro) o).agresividad))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Grado de agresividad: %s]", super.toString(), agresividad);
    }
}
