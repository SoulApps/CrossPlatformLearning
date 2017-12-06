package ejercicio22_2;

public class Sobremesa extends Ordenador implements Cloneable{

	Monitor monitor;
	
	public Sobremesa (String marca, String modelo, int stock,
			float velProcesador, int capacidadDisco, float peso, String marcaP, int resolucion){
		
		super (marca, modelo, stock, velProcesador, capacidadDisco);
		monitor = new Monitor (marcaP, resolucion);
		
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
	
			//Empieza la clase Monitor.
	
	public class Monitor {

		private String marca;
		private int resolucion;

		public Monitor(String marca, int resolucion) {
			this.marca = marca;
			this.resolucion = resolucion;

		}

		public Monitor() {
			this("Sin marca", 0);
		}

		public Object clone() {

			Monitor mon;

			try {
				mon = (Sobremesa.Monitor) super.clone();
			} catch (CloneNotSupportedException e) {
				mon = null;
			}
			return mon;
		}
		
		public boolean equals(Object obj) {

			boolean bool = false;

			if (obj instanceof Monitor) {
				if (((Monitor) obj).marca == marca
						&& ((Monitor) obj).resolucion == resolucion)
					bool = true;}

			return bool;
		}

		
		public String toString() {
			return "Monitor [ marca=" + marca + ", resolucion=" + resolucion + "p ]";
		}

	}

}
