package ejercicio22;


public class Monitor implements Cloneable {

	protected String marca;
	protected int resolucion;

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
			mon = (Monitor) super.clone();
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
