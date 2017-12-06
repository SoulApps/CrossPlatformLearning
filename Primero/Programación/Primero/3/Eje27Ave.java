package Bol7;

public abstract class Eje27Ave extends Eje27Mascota implements Cloneable{

	Eje27Alimentacion alim;

	public Eje27Ave(String nombre, double cuota, String raza, Cria[] crias, Eje27Alimentacion alim) {
		super(nombre, cuota, raza, crias);
		this.alim = alim;
	}
	
	public Eje27Ave() {
		
	}

	@Override
	public abstract void hablar();

	@Override
	public abstract String genCod();
	
	
	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Ave && super.equals(o) && ((Eje27Ave) o).alim.equals(alim)){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Ave a;
		a = (Eje27Ave) super.clone();
		
		return a;
	}
	
	
	public String toString(){
		return super.toString() + String.format("-Alimentacion: %s\n", alim);
	}

}
