package ejercicio9;

public class Sorpresa implements Cloneable{
	
	protected String nombre;
	
	public Sorpresa() throws NombreIncorrectoException{
		this("SinNombre");
	}
	
	public Sorpresa(String nombre) throws NombreIncorrectoException{
		setNombre(nombre);
	}
	
	public void setNombre(String nombre) throws NombreIncorrectoException{
		if (nombre.matches("[A-Za-z]+"))
			this.nombre = nombre;
		else 
			throw new NombreIncorrectoException("¡Error! Nombre incorrecto");
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Sorpresa && ((Sorpresa) o).nombre.equals(nombre))
			r = true;
		
		return r;
	}
	
	public Object clone(){
		Sorpresa s;
		try{
			s = (Sorpresa)super.clone();
		} catch (CloneNotSupportedException e){
			s = null;
		}
		return s;
	}

	public String toString() {
		return "Sorpresa [nombre=" + nombre + "]";
	}
}