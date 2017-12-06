package Ejercicio24;


public class Directivo extends Empleado{
	protected String descripcionCargo;
	
	
	public Directivo(String nombre,int horasTrabajadas,String descripcionCargo){
		super(nombre,horasTrabajadas);
		this.descripcionCargo=descripcionCargo;
	}

	public String toString(){
		return String.format("%sDescripción del cargo: %s",super.toString(),descripcionCargo);
	}
	
	
}
