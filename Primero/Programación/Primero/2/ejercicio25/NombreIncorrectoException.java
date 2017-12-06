package ejercicio25;

public class NombreIncorrectoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NombreIncorrectoException(String mensaje){
		super(mensaje);
	}
}
