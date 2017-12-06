package ejercicio10;

public class Coche extends VehiculoMotor{
	
	private final int NUM_RUEDAS = 4;
	
	public Coche(String matricula, Marca marca, int cilindrada, int caballos){
		super(matricula, marca, cilindrada, caballos);
	}
	
	public int calcularNumRuedas(){
		return NUM_RUEDAS;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Coche && super.equals(o))
			r = true;
		
		return r;
	}
}
