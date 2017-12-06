package ejercicio9;

public class Peluche extends Juguete {
	
	protected boolean habla;
	protected Tamanio tamanio;
	
	public Peluche() throws NombreIncorrectoException{
		this("SinDef", "SinDef", false, Tamanio.PEQUENIO);
	}
	
	public Peluche(String nombre, String color, boolean habla, Tamanio tamanio) throws NombreIncorrectoException{
		super(nombre, color);
		this.habla = habla;
		this.tamanio = tamanio;
		valorEc = valorEconomico();
	}

	public enum Tamanio{
		GRANDE (7), MEDIANO (5), PEQUENIO(2);
		
		private final int PRECIO;
		
		Tamanio (int PRECIO){
			this.PRECIO = PRECIO;
		}
		
		public int getPRECIO(){
			return PRECIO;
		}
	}
	
	public int valorEconomico(){
		return tamanio.getPRECIO();
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Peluche && super.equals(o) &&habla == ((Peluche) o).habla 
			&& tamanio == ((Peluche) o).tamanio)
			r = true;
		
		return r;
	}

	public String toString() {
		return super.toString() + "Peluche [habla=" + habla + ", tamanio=" + tamanio + "]";
	}
	
}
