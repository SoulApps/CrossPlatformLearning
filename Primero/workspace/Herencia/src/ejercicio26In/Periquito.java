package ejercicio26In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Periquito extends Ave {
    private static int numero = 001;
    private final char LETRA = 'P';
    private final String GRITO = "PICHÓN";

    public Periquito(String nombre, double cuota, String raza, boolean enfadado, Alimentacion alimentacion) {
        super(nombre, cuota, raza, enfadado, alimentacion);
        codigo = LETRA + String.valueOf(numero);
    }

    public String hablar() {
        return GRITO;
    }


    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Periquito)
            if (super.equals(o))
                igual = true;

        return igual;
    }
}
