package ejercicio25;

public class Chucheria extends Sorpresa{
	
	public Chucheria () throws NombreIncorrectoException{
		this("SinNom");
	}
	public Chucheria (String nombre) throws NombreIncorrectoException{
		super(nombre);
	}
}
