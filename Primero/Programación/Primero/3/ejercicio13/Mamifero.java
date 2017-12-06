package ejercicio13;

// la clase Mamifero es hijo de Mascota.

public abstract class Mamifero extends Mascota {

	// La variable de la clase Mamifero.
	
	protected String champuPelo;
	
	// Contructores.
	
	Mamifero(){
		
		super();
		champuPelo="Sin marca";
		
	}
	
	Mamifero(String nombre, float cuotaMensual, boolean enfadado, String raza, String champuPelo){
		
		super(nombre, cuotaMensual, enfadado, raza);
		this.champuPelo=champuPelo;
	
	}

	// EL equal de la clase Mamifero que comprueba cada una de las variables si es el adecuado.
	
	public boolean equals(Object o){
		
		boolean igual=false;
		
		if(o instanceof Mamifero){
			
			if(super.equals(o)&&champuPelo.equals(((Mamifero) o).champuPelo)){
			
				igual=true;
				
			}
			
		}
		
		return igual;
		
	}
	
	// El toString de la clase Mascota.
	
	public String toString(){

		return super.toString()+"[Marca de Champu: "+champuPelo+"]";

	}
	
	// Getters y setters
	
	public String getChampuPelo() {
		return champuPelo;
	}

	public void setChampuPelo(String champuPelo) {
		this.champuPelo = champuPelo;
	}
	
	
}
