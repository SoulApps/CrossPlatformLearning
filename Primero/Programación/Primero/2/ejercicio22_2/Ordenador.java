package ejercicio22_2;

public class Ordenador extends Producto { //No hace falta implements Cloneable porque lo tiene el padre Producto.

		protected float velProcesador;
		protected int capacidadDisco;

	public Ordenador(String marca, String modelo, int stock,
			float velProcesador, int capacidadDisco) {
		super (marca, modelo, stock);
		this.velProcesador = velProcesador;
		this.capacidadDisco = capacidadDisco;
	}
	
	public Ordenador (){
		super ("Sin marca", "000F", 0);
		velProcesador = 0;
		capacidadDisco = 0;
	}

	public Object clone() {
					
		return super.clone();

	}

	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Ordenador) {
			if (((Ordenador) obj).velProcesador == velProcesador
					&& ((Ordenador) obj).capacidadDisco == capacidadDisco
					&& super.equals(obj))
				bool = true;}
			

		return bool;
	}

	
	public String toString() {
		return "Ordenador [ marca="+marca+", modelo="+modelo+", stock="+stock+", velProcesador=" + velProcesador
				+ "GHz, capacidadDisco=" + capacidadDisco + "Gb ]";
	}


}
