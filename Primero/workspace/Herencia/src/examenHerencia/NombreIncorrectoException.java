package examenHerencia;

/**
 * Created by Alejandro on 07/03/2016.
 */
public class NombreIncorrectoException extends Exception {
    private static final long serialVersionUID = 1L;

    public NombreIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
