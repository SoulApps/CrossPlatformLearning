package Bol7;


public class Eje27Gato extends Eje27Mamifero implements Cloneable{
	static int contg=0;
	public Eje27Gato(String nombre, double cuota, String raza, Cria[] crias, String champu) {
		super(nombre, cuota, raza, crias, champu);
		cod = genCod();
	}

	@Override
	public void hablar() {
		System.out.println("Miau");
		
	}

	@Override
	public String genCod() {
		String result;
		result = String.format("G%03d", contg);
		contg++;
		return result;
	}

	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Gato && super.equals(o)){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Gato p;
		p = (Eje27Gato) super.clone();
		
		return p;
	}
	
	
	public String toString(){
		String s="";
		for(Cria c : crias){
			s = s + c.toString();
		}
		return super.toString() +s;
	}
}
