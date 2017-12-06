package Bol7;


public class Eje27Loro extends Eje27Ave{
	static int contl=0;
	boolean hablanh;
	
	public Eje27Loro(String nombre, double cuota, String raza, Cria[] crias, Eje27Alimentacion alim, boolean hablanh) {
		super(nombre, cuota, raza, crias, alim);
		this.hablanh = hablanh;
		cod = genCod();
	}

	@Override
	public void hablar() {
		System.out.println("Hola Holita");
	}

	@Override
	public String genCod() {
		String result;
		result = String.format("L%03d", contl);
		contl++;
		return result;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Loro && super.equals(o) && ((Eje27Loro)o).hablanh == hablanh){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Loro p;
		p = (Eje27Loro) super.clone();
		
		return p;
	}
	
	
	public String toString(){
		String s="";
		for(Cria c : crias){
			s = s + c.toString();
		}
		return super.toString() + String.format("-Hablan Humano?: %s\n", hablanh?"Si":"No") +s;
	}

}
