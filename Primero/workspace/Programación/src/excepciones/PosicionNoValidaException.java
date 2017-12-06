package excepciones;

/**
 * Excepci&oacute;n que se lanza cuando se intenta colocar una ficha en una posici&oacute;n no v&aacute;lida.
 *
 *
 * Created by Alejandro on 09/04/2016.
 */
public class PosicionNoValidaException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Excepci&oacute;n que se activa cuando se intenta colocar una ficha en una posici&oacute;n no v&aacute;lida.
     * @param mensaje Mensaje a mostrar.
     */
    public PosicionNoValidaException(String mensaje) {
        super(mensaje);
    }
}
