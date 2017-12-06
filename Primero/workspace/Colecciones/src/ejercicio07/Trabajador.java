package ejercicio07;
public class Trabajador extends Empleado{

	/**CONSTRUCTOR**/
	public Trabajador(String fechaAlta, String nombre, int horasTrabajadas) {
		super(fechaAlta, nombre, horasTrabajadas);
	
	}
	
	/**METODO**/
	public float calcularSueldo(){
		return SUELDO_BASE;
	}

}
