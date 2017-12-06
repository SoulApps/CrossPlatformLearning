package codigo;

public class Persona implements Cloneable, Validable{
	protected String nombre;
	protected boolean validado=false;
	protected int numOrden;
	
	Persona(String nombre) throws NombreIncorrectoException{
		setNombre(nombre);	
	}	
	public boolean equals(Object o){
		boolean result=false;
		
		if(o instanceof Persona && nombre.equals(((Persona)o).nombre))
			result=true;
		
		return result;
	}	
	public Object clone(){
		Persona clonado;
		
		try {
			clonado=(Persona)super.clone();
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}
		
		return clonado;
	}	
	public String toString() {
		return "Persona [nombre=" + nombre + ", validado=" + validado + "]";
	}
	public String tipoNumero(){
		
		return String.format("Soy el %s número %d",getClass().getSimpleName().toLowerCase(),numOrden);
	}	
	public void setNombre(String nombre) throws NombreIncorrectoException {
		nombre=nombre.trim();// Eliminamos los espacios que pudiera haber al principio y al final.
		
		if(nombre.matches("([A-ZÑ][a-zñ]+( [a-zñ]+)* ?){3}"))
			this.nombre=nombre;
		else
			throw new NombreIncorrectoException("El formato del nombre es incorrecto.");// Una exception propia.
	}	
	public void validar(){		
		validado=true;
	}	
}
