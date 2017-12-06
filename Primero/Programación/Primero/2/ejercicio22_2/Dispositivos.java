package ejercicio22_2;

public class Dispositivos extends Producto implements Cloneable{

	protected int capTarjetaMemoria;
	
	public Dispositivos (String marca, String modelo, int stock, int capTarjetaMemoria){
		
		super(marca, modelo, stock);
		this.capTarjetaMemoria = capTarjetaMemoria;
	}
	
	public Dispositivos (){
		
		super ("Sin marca", "000F", 0);
		capTarjetaMemoria = 0;
	}
	
	public Object clone() {

		return super.clone();


	}
		

	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Dispositivos) {
			if (((Dispositivos) obj).capTarjetaMemoria == capTarjetaMemoria
					&& super.equals(obj))
				bool = true;}
		
			return bool;
	}
	
	public String toString() {
		return "Dispositivo [ marca=" +marca + ", modelo=" + modelo + ", stock="
				+ stock +", Capacidad de la tarjeta de memoria="+capTarjetaMemoria +"Gb ]";
	}

	public int getCapTarjetaMemoria() {
		return capTarjetaMemoria;
	}
	
}
