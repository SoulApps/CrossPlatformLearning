package ejercicio10;

import java.util.Date;

public abstract class Vehiculo implements Cloneable{
	
	public enum Marca {
		SKIPE, GLOBE
	}
	
	protected String matricula;
	protected Marca marca;
	protected Date fechaCompra;

	public Vehiculo(String matricula, Marca marca){
		this.marca = marca;
		this.matricula = matricula;
		fechaCompra = new Date();
	}

	public int hashCode(){
		return matricula.hashCode()+marca.toString().hashCode()+fechaCompra.hashCode();
	}

	public Object clone(){
		Vehiculo v;
		
		try {
			v = (Vehiculo)super.clone();
			v.fechaCompra = (Date)fechaCompra.clone();
		} catch (CloneNotSupportedException e){
			v = null;
		}
		return v;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Vehiculo && marca == ((Vehiculo) o).marca && matricula.equalsIgnoreCase(((Vehiculo) o).matricula)
			&& fechaCompra.equals(((Vehiculo) o).fechaCompra))
			r = true;
		
		return r;
	}
	
	public String toString() {
		return String.format("- %s: matricula = %s, marca = %s",getClass().getSimpleName(), matricula, marca.toString().toLowerCase());
	}

	public abstract int calcularNumRuedas();
}
