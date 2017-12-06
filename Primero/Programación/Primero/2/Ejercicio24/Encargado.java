package Ejercicio24;

public class Encargado extends Directivo{
	
	public Encargado(String nombre,int horasTrabajadas,String descripcionCargo){
		super(nombre,horasTrabajadas,descripcionCargo);
		sueldo=SUELDOBASE*1.2f;
	}
	
	
	
}
