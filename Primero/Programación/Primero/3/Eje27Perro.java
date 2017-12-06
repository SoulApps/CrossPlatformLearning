package Bol7;

public class Eje27Perro extends Eje27Mamifero implements Cloneable{

	int agresividad;
	static int contp=0;
	
	public Eje27Perro(String nombre, double cuota, String raza, Cria crias[], String champu, int agresividad) {
		super(nombre, cuota, raza, crias, champu);
		this.agresividad = agresividad;
		cod = genCod();
	}

	@Override
	public void hablar() {
		System.out.println("Guau");
	}


	@Override
	public String genCod() {
		String result;
		
		result = String.format("P%03d", contp);
		contp++;
		
		return result;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Perro && super.equals(o) && ((Eje27Perro) o).agresividad == agresividad){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Perro p;
		p = (Eje27Perro) super.clone();
		
		return p;
	}

	public String toString(){
		String s="";
		for(Cria c : crias){
			s = s + c.toString();
		}
		return super.toString() + String.format("-Agresividad: %s\n", agresividad) +s;
	}
}
