package ejercicio07;

public abstract class Directivo extends Empleado{
	
	/**ATRIBUTOS**/
	protected String descripcionCargo;
	
	/**CONSTRUCTOR**/
	public Directivo(String fechaAlta, String nombre,int horasTrabajadas, String descripcionCargo){
		super(fechaAlta, nombre, horasTrabajadas);
		this.descripcionCargo = descripcionCargo;
	}

	//Calcular sueldo lo heredo como abstracto y no lo modifico por que no tengo la informacion para calcularlo.
	public abstract float calcularSueldo();
	
	/**EQUALS**/
	public boolean equals(Object o){
		boolean igual=false;
		if(o instanceof Directivo && super.equals(o) && ((Directivo) o).descripcionCargo.equals(descripcionCargo))
				igual=true;
		return igual;
	}
	
	/**toString**/
	public String toString(){
		return String.format("%sDescripci�n del cargo: %s",super.toString(),descripcionCargo);
	}

}
