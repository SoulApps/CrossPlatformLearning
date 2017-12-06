package ejercicio26;


public class Triciclo extends Vehiculo {
	
	private final byte NUMRUEDAS = 3;
	
	public Triciclo (String matricula, Marca marca){
		super(matricula, marca);
		
	}
	
	public Triciclo (){
		super ("000F", Marca.GLOBE);
		
	}

	public byte calcularNumRuedas() {
		return NUMRUEDAS;
	}

	
	public boolean equals(Object obj) { 

		boolean bool = false;

		if (obj instanceof Triciclo) { if (super.equals(obj)) bool = true;}
		
		return bool;
	}
	
	public String toString() {
		return String.format("Triciclo: %s, %d ruedas", super.toString(), calcularNumRuedas());
	}

}
