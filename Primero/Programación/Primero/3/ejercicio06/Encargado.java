package ejercicio06;

public class Encargado extends Directivo {

	public Encargado(){
		this("SinNombre", 0, "SinDesc");
	}
	
	public Encargado(String nombre, float sueldo, String descripcion){
		super(nombre, sueldo, descripcion);
		this.sueldo = sueldo+sueldo*0.20f;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Encargado && super.equals(o))
			r = true;
		
		return r;
	}
	
}
