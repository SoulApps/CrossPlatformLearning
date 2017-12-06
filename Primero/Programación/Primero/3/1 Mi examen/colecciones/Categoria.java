package colecciones;

public enum Categoria {

	JEFE, ENCARGADO, EMPLEADO;
	
	private static char c;

	public static char getCodigo(Categoria categoria){
		
		if(categoria==JEFE)
			c='J';
		else if(categoria==ENCARGADO)
			c='E';
		else if(categoria==EMPLEADO)	
			c='D';
		return c;
			
	}
}
