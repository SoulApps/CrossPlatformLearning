package ejercicio07;
public class Jefe extends Directivo{
	
	/**CONSTRUCTOR**/
	public Jefe(String fechaAlta, String nombre, int horasTrabajadas, String descripcionCargo) {
		super(fechaAlta, nombre, horasTrabajadas, descripcionCargo);
	}

	/**METODOS**/
	public float calcularSueldo (){
		return SUELDO_BASE*1.50f;
	}

	
}
