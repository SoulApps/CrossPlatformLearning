package codigo;


public class NombreIncorrectoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	NombreIncorrectoException(String mensaje){
		super(mensaje);
	}
}
