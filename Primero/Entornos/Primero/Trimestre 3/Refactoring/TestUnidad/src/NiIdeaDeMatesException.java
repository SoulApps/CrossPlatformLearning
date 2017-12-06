
public class NiIdeaDeMatesException extends Exception{

	private String mensaje;
	public NiIdeaDeMatesException(String mensaje){
		this.mensaje = mensaje;
	}


	public String toString(){
		return mensaje;
	}

}
