package ejercicio11;

import java.util.Random;

public class Periquitos extends Aves {
	
	private final char LETRA='R';
	public static int numPeriquitos=0;
	
	Periquitos(String nombre, double cuotaMensual, String raza, Alimentacion alimentacion){
		super(nombre, cuotaMensual, raza, alimentacion);
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
