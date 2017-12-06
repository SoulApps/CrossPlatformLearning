package ejercicio24In;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class NombreIncorrectoException extends Exception {
    private static final long serialVersionUID = 1L;

    public NombreIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
