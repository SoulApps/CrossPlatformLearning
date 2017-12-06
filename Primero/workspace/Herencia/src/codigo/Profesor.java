package codigo;


public class Profesor extends Persona implements Asalariado{
	private float sueldo;
	private static int numero=0;
	
	Profesor(String nombre, float sueldo) throws NombreIncorrectoException {
		super(nombre);
		this.sueldo=sueldo;
		numOrden=++numero;
	}	
	public boolean equals(Object o){
		boolean result=false;
		
		if(o instanceof Profesor && super.equals(o) && sueldo==((Profesor)o).sueldo)
			result=true;
		
		return result;
	}
	public String toString() {
		return "Profesor ["+super.toString()+" sueldo=" + sueldo + "]";
	}
	public void aumentarSueldo(int porcentaje) {
		sueldo=sueldo*(1+(float)porcentaje/100);
	}	
}
