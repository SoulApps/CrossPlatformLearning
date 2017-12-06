package herenciaEjercicio27;

// La clase Perro es hijo de Mamifero y es abulo de Mascota.

public class Perro extends Mamifero{

	// las variables de la clase Perro.
	
	final static char LETRA='P';
	final static String VOZ="GUAU!";
	static short numero=0;
	protected GradoAgresividad gradoAgresividad;
	
	
	// Contructores.
	
	Perro(){
		
		this("Sin nombre",0,false,"Sin raza","Sin champu", GradoAgresividad.BAJA);
		
	}
	
	Perro(String nombre, float cuotaMensual, boolean enfadado, String raza, String champuPelo,
			GradoAgresividad gradoAgresividad){
		
		super(nombre, cuotaMensual, enfadado, raza, champuPelo);
		this.gradoAgresividad=gradoAgresividad;
		numero++;
		codigo=String.format("%c%03d",LETRA, numero);
		
	}
	
	// EL equal de la clase Mamifero que comprueba cada una de las variables si es el adecuado.
	
	public boolean equals(Object o){
		
		boolean igual=false;
		
		if(o instanceof Perro){
			
			if(super.equals(o)&&gradoAgresividad==(((Perro) o).gradoAgresividad)){
			
				igual=true;
				
			}
			
		}
		
		return igual;
		
	}
	
	// El metodo hablar.
	
	public String hablar() {
		
		return VOZ;
		
	}
	
	// El toString de la clase Perro.
	
	public String toString(){

		return super.toString()+"\n[Grado de agresividad: "+gradoAgresividad+"]";

	}
}
