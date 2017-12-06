package ejercicio06;

public class Directivo extends Empleado{

	protected String descripcion;
	
	public Directivo(){
		this("SinNombre", 0, "SinDesc");
	}
	
	public Directivo(String nombre, float sueldo, String descripcion){
		super(nombre, sueldo);
		this.descripcion = descripcion;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Directivo && super.equals(o) && descripcion.equals(((Directivo) o).descripcion))
			r = true;
		
		return r;
	}
	
	public String toString() {
		return super.toString() + "Directivo [descripcion=" + descripcion + "]";
	}

	public Object clone(){
		return super.clone();
	}
}
