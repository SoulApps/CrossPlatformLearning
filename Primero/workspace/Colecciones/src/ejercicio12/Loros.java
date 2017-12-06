package ejercicio12;

import java.util.Date;
import java.util.Random;

public class Loros extends Aves {

	boolean hablan;
	public static int numLoros=0;
	
	
	Loros(String nombre, double cuotaMensual, String raza, Alimentacion alimentacion, boolean hablan, Date fnac){
		super(nombre, cuotaMensual, raza, alimentacion, fnac);
		this.hablan=hablan;
		numLoros++;
		codigo=String.format("%c%03d", getClass().getSimpleName().charAt(0),numLoros);
	}
	
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Loros && super.equals(obj) && hablan==((Loros)obj).hablan)
				resultado=true;
		return resultado;		
	}


	public String toString() {
		return String.format("%s%nAlimentacion: %s%nHablan: %s", super.toString(), alimentacion, hablan?"Si":"No");
	}
	
	public String hablar(){
		return String.format("%s","Geaa, hola, bartolo");
	}


	public boolean enfadarse() {
		Random aleatorio = new Random();
		
		return aleatorio.nextBoolean();
		
	}
}
