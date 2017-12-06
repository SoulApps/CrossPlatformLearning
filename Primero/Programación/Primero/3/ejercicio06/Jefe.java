package ejercicio06;

public class Jefe extends Directivo{
	
	public Jefe(){
		this("SinNombre", 0, "SinDesc");
	}
	
	public Jefe(String nombre, float sueldo, String descripcion){
		super(nombre, sueldo, descripcion);
		this.sueldo = sueldo+sueldo*0.50f;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Jefe && super.equals(o))
			r = true;
		
		return r;
	}
	
	public String toString() {
		return super.toString();
	}

	public Object clone(){
		return super.clone();
	}
}
