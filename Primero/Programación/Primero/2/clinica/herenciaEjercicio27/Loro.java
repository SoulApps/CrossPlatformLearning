package herenciaEjercicio27;

// La clase Loro es hijo de Ave y abuelo de Mascota.

public class Loro extends Ave {

	// La variable de la clase Loro.
	
	final static char LETRA='L';
	final static String VOZ1="RUAK!";
	final static String VOZ2="BARCOS Y PUTAS PARA TODOS!";
	static short numero;
	private boolean hablaH;
	
	
	// Contructores.
	
	Loro(){
		
		this("Sin nombre",0,false,"Sin raza",Alimentacion.CARNIVORA,false);
		
	}
	
	Loro(String nombre,float cuotaMensual, boolean enfadado, String raza, Alimentacion alimentacion, boolean hablaH){
		
		super(nombre,cuotaMensual,enfadado,raza,alimentacion);
		this.hablaH=hablaH;
		numero++;
		codigo=String.format("%c%03d",LETRA, numero);
		
	}
	
	// EL equal de la clase Loro que comprueba cada una de las variables si es el adecuado.
	
	public boolean equals(Object o){
		
		boolean igual=false;
		
		if(o instanceof Loro){
			
			if(super.equals(o)&&hablaH==(((Loro) o).hablaH)){
			
				igual=true;
				
			}
			
		}
		
		return igual;
		
	}
	
	// El metodo hablar.
	
	public String hablar() {
		
		return hablaH?VOZ2:VOZ1;
		
	}
	
	public boolean isHablaH() {
		return hablaH;
	}

	public void setHablaH(boolean hablaH) {
		this.hablaH = hablaH;
	}
	
	// El toString de la clase Loro.
	
	public String toString(){

		return super.toString()+"\n[Habla: "+hablaH+"]";

	}
 
}
