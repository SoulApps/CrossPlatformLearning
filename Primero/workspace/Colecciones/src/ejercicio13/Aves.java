package ejercicio13;

import java.util.Date;

public abstract class Aves extends Animal {

	Alimentacion alimentacion;
	
	Aves(String nombre, double cuotaMensual, String raza, Alimentacion alimentacion, Date fnac){
		super(nombre,cuotaMensual, raza, fnac);
		this.alimentacion=alimentacion;
	}

	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Aves && super.equals(obj) && alimentacion==((Aves)obj).alimentacion)
				resultado=true;
		return resultado;		
	}
}
