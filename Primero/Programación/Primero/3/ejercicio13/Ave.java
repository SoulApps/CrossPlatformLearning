package ejercicio13;

// La clase Ave es hijo de Mascota. 

public abstract class Ave extends Mascota {
 
	// La variable de la clase Ave.
	
	public Alimentacion alimentacion;
	
	// Contructores.
	
	Ave(){
		
		super();
		alimentacion=Alimentacion.INSECTIVORA;
		
	}
	
	Ave(String nombre,float cuotaMensual, boolean enfadado, String raza, Alimentacion alimentacion){
		
		super(nombre, cuotaMensual, enfadado, raza);
		this.alimentacion=alimentacion;
		
	}

	// EL equal de la clase Ave que comprueba cada una de las variables si es el adecuado.
	
	public boolean equals(Object o){
		
		boolean igual=false;
		
		if(o instanceof Ave){
			
			if(super.equals(o)&&alimentacion==(((Ave) o).alimentacion)){
			
				igual=true;
				
			}
			
		}
		
		return igual;
		
	}
	
	//Getters y setters
	
	public Alimentacion getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(Alimentacion alimentacion) {
		this.alimentacion = alimentacion;
	}
	
	// El toString de la clase Ave.
	
	public String toString(){

		return super.toString()+"[Alimentacion: "+alimentacion+"]";

	}
	
}
