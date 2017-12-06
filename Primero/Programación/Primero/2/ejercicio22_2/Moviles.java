package ejercicio22_2;

public class Moviles extends Dispositivos implements Cloneable{
	
	protected Cobertura cobertura;
	
	public enum Cobertura {
		
		COBERTURA_3G, COBERTURA_4G;
	}

	public Moviles (String marca, String modelo, int stock, int capTarjetaMemoria, Cobertura cobertura){
			
		super(marca, modelo, stock, capTarjetaMemoria);
		this.cobertura = cobertura;
	}

	public Moviles (){
		super ("Sin marca", "000F", 0, 0);
		cobertura = Cobertura.COBERTURA_3G;
	}
	
	public Object clone() {

		return super.clone();


	}
		

	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Moviles) {
			if (((Moviles) obj).cobertura == cobertura
					&& super.equals(obj))
				bool = true;}
			
		return bool;
	}
	
	public String toString() {
		return "Movil [ marca=" + marca + ", modelo=" + modelo + ", stock="
				+ stock +", Capacidad de la tarjeta de memoria="+capTarjetaMemoria+"Gb, cobertura="+ cobertura +" ]";
	}
	
}
