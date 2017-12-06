package ejercicio26;



public class Coche extends Vehiculos_motor{

	private final byte NUMRUEDAS = 4;
	
	public Coche(String modelo, Marca marca, int cilindrada, int caballos) {
		super(modelo, marca, cilindrada, caballos);

	}
	
	public Coche (){
		super("000F", Marca.GLOBE, 0, 0);

	}

	public byte calcularNumRuedas() {
	
		return NUMRUEDAS;
	}
	

	public boolean equals (Object obj){
		boolean r = false;
		
		if (obj instanceof Coche && super.equals(obj)) r = true;
	
		return r;
	}


	
	public String toString() {
		return String.format("Coche: %s", super.toString());
	}
}
