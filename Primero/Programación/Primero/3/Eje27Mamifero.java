package Bol7;

public abstract class Eje27Mamifero extends Eje27Mascota implements Cloneable{

	String champu;
	
	public Eje27Mamifero(String nombre, double cuota, String raza, Cria crias[], String champu) {
		super(nombre, cuota, raza, crias);
		this.champu = champu;
	}

	@Override
	public abstract void hablar();

	@Override
	public abstract String genCod();
	
	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Mamifero && super.equals(o) && ((Eje27Mamifero) o).champu.equals(champu)){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Mamifero m;
		m = (Eje27Mamifero) super.clone();
		
		return m;
	}

	public String toString(){
		return super.toString() + String.format("-Champu: %s\n", champu);
	}
}
