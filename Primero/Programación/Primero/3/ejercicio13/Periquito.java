package ejercicio13;

//La clase Periquito es hijo de Ave y abuelo de Mascota.

public class Periquito extends Ave {

	// La variable de la clase Periquito.
	final static char LETRA='R';
	final static String VOZ="PIRIRI!";
	static short numero;
	
	// Contructores.
	
	Periquito(){
		
		this("Sin nombre",100.5f,false,"Sin raza",Alimentacion.HERBIVORA);
		
	}
	
	Periquito(String nombre,float cuotaMensual, boolean enfadado, String raza, Alimentacion alimentacion){
		
		super(nombre,cuotaMensual,enfadado,raza,alimentacion);
		numero++;
		codigo=String.format("%c%03d",LETRA, numero);
	
		
	}
	
	// EL equal de la clase Periquito que comprueba cada una de las variables si es el adecuado.
	
	public boolean equals(Object o){
		boolean igual=false;
		if(o instanceof Periquito && super.equals(o)){
			igual=true;
		}
		return igual;
	}
	
	// El metodo hablar.
	
	 public String hablar(){
			
			return VOZ;
			
		}
	
}
