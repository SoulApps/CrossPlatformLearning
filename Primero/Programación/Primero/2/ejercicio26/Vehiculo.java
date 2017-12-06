package ejercicio26;


import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Vehiculo implements Cloneable{
	
	protected String matricula;
	protected Marca marca;
	protected Date fecha;
	
	
	
	public Vehiculo (String matricula, Marca marca){
		this.matricula = matricula;
		this.marca = marca;
		fecha = new Date();
		
				
	}
	
	public Vehiculo (){
		
		this("000F", Marca.SKIPE);		
		fecha = new Date();
		
	}
	
	public enum Marca{
		SKIPE, GLOBE
	}
	
	public Object clone(){
		
		Vehiculo v;
		
		try {
			v=(Vehiculo)super.clone();
		} catch (CloneNotSupportedException e) {
			v=null;
		}
		return v;		
		
	}
	
	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Vehiculo){
			if (((Vehiculo) obj).matricula.equals(matricula)
				&& ((Vehiculo) obj).marca == marca)
				bool = true;}
			
		return bool;
	}

	
	public abstract byte calcularNumRuedas();
	
	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return "matricula=" + matricula + ", marca=" + marca+", fecha de compra= "+formato.format(fecha);
	}
	
}
