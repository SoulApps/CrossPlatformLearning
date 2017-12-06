package ejercicio11;

public class Perros extends Mamiferos{

	int agresividad;
	public static int numPerros=0;
	
	
	Perros(String nombre, double cuotaMensual, String raza, String champu, boolean enfadado, int agresividad){
		super(nombre, cuotaMensual, raza, champu, enfadado);
		this.agresividad=agresividad;
		numPerros++;
		codigo=String.format("%c%03d", getClass().getSimpleName().charAt(0),numPerros);
		
	}
	
	
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Perros && super.equals(obj) && agresividad==(((Perros)obj).agresividad))
				resultado=true;
		return resultado;		
	}

	public String hablar(){
		return String.format("%s","Guau");
	}
	
	public boolean enfadarse() {
		return enfadado;
		
	}

	@Override
	public String toString() {
		return String.format("%s%nAgresividad: %d", super.toString(), agresividad);
	}
	
	
}
