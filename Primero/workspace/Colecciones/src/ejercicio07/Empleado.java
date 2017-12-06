package ejercicio07;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Empleado implements Cloneable, Trabajar {

	/** ATRIBUTOS **/
	protected String nombre;
	protected float sueldo;
	protected final float SUELDO_BASE = 900.50f;
	protected String fechaAlta;
	protected int horasTrabajadas;
	protected ArrayList<Ventas> ventas = new ArrayList<Ventas>();
	//protected Ventas ventas[] = new Ventas[5];
	protected int cantVentas;
	protected long totalImporte;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Ventas> ventas) {
		this.ventas = ventas;
	}

	public int getCantVentas() {
		return cantVentas;
	}

	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}

	/** CONSTRUCTOR **/
	public Empleado(String fechaAlta, String nombre, int horasTrabajadas) {
		this.fechaAlta = fechaAlta;
		this.nombre = nombre;
		this.horasTrabajadas = horasTrabajadas;
		sueldo = calcularSueldo();
	}

	/** METODOS **/
	public abstract float calcularSueldo();

	// Implementados de Trabajar
	public void incrementar_horas_trabajadas(int num) {
		horasTrabajadas += num;
	}

	public void aumento_productividad(int porcentaje) {
		sueldo += totalImporte * porcentaje / 100;
	}

	public void venta_realizada(int numVenta, long importe) {
		if (cantVentas < ventas.size()) {
			ventas.add(new Ventas(numVenta, importe));
			//ventas[cantVentas] = new Ventas(numVenta, importe);
			totalImporte += importe;
			cantVentas++;
		}
	}

	/** EQUALS **/
	public boolean equals(Object o) {
		boolean igual = false;
		/*if (o instanceof Empleado && horasTrabajadas == ((Empleado) o).horasTrabajadas
				&& ((Empleado) o).nombre.equals(nombre) && cantVentas == ((Empleado) o).cantVentas
				&& sueldo == ((Empleado) o).sueldo && totalImporte == ((Empleado) o).totalImporte
				&& Arrays.equals(ventas, ((Empleado) o).ventas) && ((Empleado) o).fechaAlta.equals(fechaAlta))*/
		if (o instanceof Empleado && horasTrabajadas == ((Empleado) o).horasTrabajadas
				&& ((Empleado) o).nombre.equals(nombre) && cantVentas == ((Empleado) o).cantVentas
				&& sueldo == ((Empleado) o).sueldo && totalImporte == ((Empleado) o).totalImporte
				&& ((Empleado) o).ventas.equals(ventas) && ((Empleado) o).fechaAlta.equals(fechaAlta))

			igual = true;

		return igual;
	}

	/*@Override
	public int hashCode() { // Necesario para comprar.
		int result = nombre.hashCode();
		result = 31 * result + (sueldo != +0.0f ? Float.floatToIntBits(sueldo) : 0);
		result = 31 * result + (SUELDO_BASE != +0.0f ? Float.floatToIntBits(SUELDO_BASE) : 0);
		result = 31 * result + fechaAlta.hashCode();
		result = 31 * result + horasTrabajadas;
		result = 31 * result + ventas.hashCode();
		result = 31 * result + cantVentas;
		result = 31 * result + (int) (totalImporte ^ (totalImporte >>> 32));
		return result;
	}*/

	/** CLON **/

	public Object clone() {
		Empleado clonado;
		int i;
		try {
			
			clonado = (Empleado) super.clone();
			clonado.ventas = (ArrayList<Ventas>) ventas.clone();
			// Hay que clonar cada posicion del array ya que es de objetos
			for (i = 0; i < cantVentas; i++)
				clonado.ventas.set(i, (Ventas) ventas.get(i).clone());
			
		} catch (CloneNotSupportedException e) {
			clonado = null;
		}
		return clonado;
	}

	/** toString **/
	public String toString() {

		int i;
		String cadena = "";
		for (i = 0; i < cantVentas; i++)
			cadena += "\n\t" + ventas.get(i).toString();

		return String.format("Nombre: %s%nCargo: %s%nSueldo: %.2f�%nHoras Trabajadas: %d%nFecha de alta: %s%nNumVentas: %d%nImporteTotal: %d%n%s%s",
				nombre, getClass().getSimpleName(), sueldo, horasTrabajadas, fechaAlta,cantVentas, totalImporte,
				(cantVentas > 0) ? "\tVENTAS:" : "", cadena);
	}
	


}
