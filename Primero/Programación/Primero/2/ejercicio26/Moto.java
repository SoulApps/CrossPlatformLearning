package ejercicio26;

public class Moto extends Vehiculos_motor {

	private final byte NUMRUEDAS = 2;	
	
	public Moto(String modelo, Marca marca, int cilindrada, int caballos) {
		super(modelo, marca, cilindrada, caballos);

	}

	
	public Moto() {
		super("000F", Marca.GLOBE, 0, 0);

	}

	public byte calcularNumRuedas() {

		return NUMRUEDAS;
	}

	
	public boolean equals (Object obj){
		boolean r = false;
		
		if (obj instanceof Moto && super.equals(obj)) r = true;
	
		return r;
	}



	public String toString() {
		return String.format("Moto: %s", super.toString());
	}

}
