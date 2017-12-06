package ejercicio10;

public class Triciclo extends Vehiculo {

	private final int NUM_RUEDAS = 3;

	public Triciclo(String matricula, Marca marca){
		super(matricula, marca);
	}
	
	public int calcularNumRuedas(){
		return NUM_RUEDAS;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Triciclo && super.equals(o))
			r = true;
		
		return r;
	}
	
	public String toString() {
		return String.format("%s, número de ruedas = %d", super.toString(), calcularNumRuedas());
	}
}
