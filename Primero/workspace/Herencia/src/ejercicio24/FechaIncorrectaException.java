package ejercicio24;

/**
 * Created by Alejandro on 11/04/2016.
 */
public class FechaIncorrectaException extends Exception {
    private static final long serialVersionUID = 1L;

    public FechaIncorrectaException(String mensaje) {
        super(mensaje);
    }
}
