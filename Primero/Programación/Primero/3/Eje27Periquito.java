package Bol7;


public class Eje27Periquito extends Eje27Ave{

	static int contPe=0;
	
	public Eje27Periquito(String nombre, double cuota, String raza, Cria[] crias, Eje27Alimentacion alim) {
		super(nombre, cuota, raza, crias, alim);
		cod = genCod();
	}
	
	public Eje27Periquito() {
		
	}

	@Override
	public void hablar() {
		System.out.println("Pio Pio");
		
	}

	@Override
	public String genCod() {
		String result;
		result = String.format("R%03d", contPe);
		contPe++;
		return result;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Periquito && super.equals(o)){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Periquito p;
		p = (Eje27Periquito) super.clone();
		
		return p;
	}

	public String toString(){
		String s="";
		for(Cria c : crias){
			s = s + c.toString();
		}
		return super.toString()+s;
	}
}
