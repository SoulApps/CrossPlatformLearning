package ejercicio22;

public class Producto implements Cloneable {

	protected String marca;
	protected String modelo;
	protected int stock;
	
	public Producto (String marca, String modelo, int stock){
		
		this.marca = marca;
		this.modelo = modelo;
		this.stock = stock;
				
	}
	
	public Producto (){
		this("Sin marca", "000F", 0);
				
	}

	public Object clone() {

		Producto p;
		
		try {
			p=(Producto)super.clone();
		} catch (CloneNotSupportedException e) {
			p=null;
		}
		return p;

	}

	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Producto){
			if (((Producto) obj).marca.equals(marca)
					&& ((Producto) obj).modelo.equals(modelo)
					&& ((Producto) obj).stock == stock)
				bool = true;}
			
		return bool;
	}

	
	public String toString() {
		return "Producto [ marca=" + marca + ", modelo=" + modelo + ", stock="
				+ stock + " ]";
	}


}
