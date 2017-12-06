package ejercicio25;

public abstract class Juguete extends Sorpresa{
	
	protected String color;
	protected int valorEc;
	
	public Juguete() throws NombreIncorrectoException{
		this ("SinDef", "SinDef");
	}
	
	public Juguete(String nombre, String color) throws NombreIncorrectoException{
		super(nombre);
		this.color = color;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Juguete && super.equals(o) && color.equals(((Juguete) o).color) 
			&& valorEc == ((Juguete) o).valorEc)
			r = true;
		
		return r;
	}

	public String toString() {
		return super.toString() + "Juguete [color=" + color + ", valorEc=" + valorEc + "]";
	}
	
	public abstract int valorEconomico();
}
