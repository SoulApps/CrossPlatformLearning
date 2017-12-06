package ejercicio07;
public class Encargado extends Directivo {
	
	/**CONSTRUCTOR**/
	public Encargado(String fechaAlta, String nombre, int horasTrabajadas, String descripcionCargo) {
		super(fechaAlta, nombre, horasTrabajadas, descripcionCargo);
	}
	
	/**METODOS**/
	public float calcularSueldo (){
		return SUELDO_BASE*1.20f;
	}

}
