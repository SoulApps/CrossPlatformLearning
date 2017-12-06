package ejercicio22;

public class Sobremesa extends Ordenador implements Cloneable{

	protected Monitor monitor;
	
	public Sobremesa (String marca, String modelo, int stock,
			float velProcesador, int capacidadDisco, float peso, Monitor monitor){
		
		super (marca, modelo, stock, velProcesador, capacidadDisco);
		this.monitor = monitor;
		
	}
	
	public Sobremesa (){
		super ("Sin marca", "000F", 0, 0, 0);
		monitor = null;
	}
	
	public Object clone() {

		return super.clone();
	}

	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Sobremesa) {
			if (((Sobremesa) obj).monitor == monitor
					&&super.equals(obj))
				bool = true;}

		return bool;
	}
	public String toString() {
		return "Sobremesa [ marca="+marca+", modelo="+modelo+", stock="+stock+", velProcesador=" + velProcesador
				+ "GHz, capacidadDisco=" + capacidadDisco +"Gb, "+monitor.toString()+ " ]";
	}
}
