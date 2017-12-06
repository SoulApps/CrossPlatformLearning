package Ejercicio24;

public class Jefe extends Directivo{
	
	public Jefe(String nombre,int horasTrabajadas,String descripcionCargo){
		super(nombre,horasTrabajadas,descripcionCargo);
		sueldo= SUELDOBASE*1.5f;
	}

	

}
