package ejercicio22_2;

public class Camaras extends Dispositivos implements Cloneable{

	protected TipoCam tipoCam;
	protected TipoCam2 tipoCam2;
	
	public enum TipoCam {
		REFLEX, COMPACTA;
	}
	
	public enum TipoCam2 {
		ANALOGICA, DIGITAL;
	}
	
	public Camaras (String marca, String modelo, int stock, int capTarjetaMemoria, TipoCam tipoCam, TipoCam2 tipoCam2){
		
		super(marca, modelo, stock, capTarjetaMemoria);
		this.tipoCam = tipoCam;
		this.tipoCam2 = tipoCam2;		
	}

	public Camaras (){
		super ("Sin marca", "000F", 0, 0);
		tipoCam = TipoCam.REFLEX;
		tipoCam2 = TipoCam2.ANALOGICA;
	}
	
	public Object clone() {

		return super.clone();


	}
	
	public boolean equals(Object obj) {

		boolean bool = false;

		if (obj instanceof Camaras) {
			if (((Camaras) obj).tipoCam == tipoCam
					&&((Camaras) obj).tipoCam2 == tipoCam2
					&& super.equals(obj))
				bool = true;}
			
		return bool;
	}
	
	public String toString() {
		return "Camara [ marca=" + marca + ", modelo=" + modelo + ", stock="
				+ stock +", Capacidad de la tarjeta de memoria="+capTarjetaMemoria+"Gb, Tipo de camara segun tamaño="+tipoCam2+", Tipo de camara="+tipoCam+" ]";
	}
}
