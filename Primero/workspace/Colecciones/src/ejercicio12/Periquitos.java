package ejercicio12;

import java.util.Date;
import java.util.Random;

public class Periquitos extends Aves {
	
	private final char LETRA='R';
	public static int numPeriquitos=0;
	
	Periquitos(String nombre, double cuotaMensual, String raza, Alimentacion alimentacion, Date fnac){
		super(nombre, cuotaMensual, raza, alimentacion, fnac);
		numPeriquitos++;
		codigo=String.format("%c%03d", LETRA,numPeriquitos);
	}
	
	
	public String toString() {
		return String.format("%s%nAlimentacion: %s", super.toString(), alimentacion);
	}
	
	public String hablar(){
		return String.format("%s","pio");
	}


	public boolean enfadarse() {
		Random aleatorio = new Random();
		
		return aleatorio.nextBoolean();
		
	}
}
