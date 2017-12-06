package ejercicio13;

import java.util.Date;

public class Gatos extends Mamiferos {

	public static int numGatos=0;
	
	
	Gatos(String nombre, double cuotaMensual, String raza, String champu, boolean enfadado, Date fnac){
		super(nombre, cuotaMensual, raza, champu, enfadado, fnac);
		  numGatos++;
		  codigo=String.format("%c%03d", getClass().getSimpleName().charAt(0),numGatos);
	}
	
	
	
	public String hablar(){
		return String.format("%s","Miau");
	}
	
	public boolean enfadarse() {
		return enfadado;
		
	}
	
}
