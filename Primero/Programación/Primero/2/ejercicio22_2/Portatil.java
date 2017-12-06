package ejercicio22_2;

public class Portatil extends Ordenador implements Cloneable{

	protected float peso;
	
	public Portatil (String marca, String modelo, int stock,
			float velProcesador, int capacidadDisco, float peso){
		
		super(marca, modelo, stock, velProcesador, capacidadDisco);
		this.peso = peso;
		
	}
	public Portatil (){
		super ("Sin marca", "000F", 0, 0, 0);
		peso = 0;
	}
	
	public Object clone() {

		return super.clone();
		
	}

	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Portatil) {
			if (((Portatil) obj).peso == peso
					&& super.equals(obj))
				bool = true;}
		
		return bool;
	}
	
	public String toString() {
		return "Portatil [ marca="+marca+", modelo="+modelo+", stock="+stock+", velProcesador=" + velProcesador
				+ "GHz, capacidadDisco=" +capacidadDisco+"Gb, peso="+peso+"Kg ]";
	}
}
