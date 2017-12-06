package ejercicio26In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class Gato extends Mamifero {
    private static int numero = 001;
    private final char LETRA = 'G';
    private final String GRITO = "NYAN NYAN NYAN NYAN NYAN";

    public Gato(String nombre, double cuota, String raza, boolean enfadado, String champu) {
        super(nombre, cuota, raza, enfadado, champu);
        codigo = LETRA + String.valueOf(numero);
        numero++;
    }

    public String hablar() {
        return GRITO;
    }
}
