package ejercicio10;

public class Moto extends VehiculoMotor{

	private final int NUM_RUEDAS = 2;
	
	public Moto(String matricula, Marca marca, int cilindrada, int caballos){
		super(matricula, marca, cilindrada, caballos);
	}
	
	public int calcularNumRuedas(){
		return NUM_RUEDAS;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Moto && super.equals(o))
			r = true;
		
		return r;
	}
}
