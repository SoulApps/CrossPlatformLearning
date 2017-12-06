package herenciaEjercicio27;

//La clase Gato es hijo de Mamifero y es abulo de Mascota.

public class Gato extends Mamifero {

	// las variables de la clase Gato.
	final static char LETRA='G';
	final static String VOZ="MIAU!";
	static short numero=0;

	//private short numero;
	
	// Contructores.
	
	Gato(){
		
		this("Sin nombre",0,false,"Sin raza","Sin champu");
		
	}
	
	Gato(String nombre, float cuotaMensual, boolean enfadado, String raza, String champuPelo){
		
		super(nombre, cuotaMensual, enfadado, raza, champuPelo);
		numero++;
		codigo=String.format("%c%03d",LETRA, numero);
	
		
	}
	
	// EL equal de la clase Gato que comprueba cada una de las variables si es el adecuado.
	
	public boolean equals(Object o){
		boolean igual=false;
		if(o instanceof Gato && super.equals(o)){
			igual=true;
		}
		return igual;
	}
	
// El metodo hablar.
	
public String hablar() {
		
		return VOZ;
		
	}

}
