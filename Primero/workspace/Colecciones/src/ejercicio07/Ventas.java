package ejercicio07;
public class Ventas implements Cloneable{
    
	/**ATRIBUTOS**/
	private int numVenta;
	private long importe; 
	
	/**CONSTRUCTOR**/
	public Ventas(int numVenta,long importe){
		this.numVenta=numVenta;
		this.importe=importe;
	}
	
	/**EQUALS**/
	public boolean equals(Object o){
		boolean igual=false;
		if(o instanceof Ventas && importe ==((Ventas) o).importe && numVenta ==((Ventas)o).numVenta)
				igual=true;
		return igual;
	}
	
	/**CLON**/
	public Object clone(){
		Ventas clonado;
		try {
			clonado=(Ventas) super.clone();
		} catch (CloneNotSupportedException e) {
			clonado=null;
			e.printStackTrace();
		}
		return clonado;
	}

	/**toString**/
	public String toString(){
		return String.format("N�mero de venta : %d%n\tImporte: %d�%n", numVenta,importe);
	}
}

