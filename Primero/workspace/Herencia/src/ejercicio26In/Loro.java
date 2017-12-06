package ejercicio26In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Loro extends Ave {
    private static int numero = 001;
    private final char LETRA = 'L';
    private final String GRITO = "¡LORITO QUIERE LATINOS!";
    private boolean habla;

    public Loro(String nombre, double cuota, String raza, boolean enfadado, Alimentacion alimentacion, boolean habla) {
        super(nombre, cuota, raza, enfadado, alimentacion);
        this.habla = habla;
        codigo = LETRA + String.valueOf(numero);
        numero++;
    }


    public String hablar() {
        return GRITO;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Loro)
            if (super.equals(o) && habla == ((Loro) o).habla)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Halba: %s]", super.toString(), habla?"Sí":"No");
    }
}
