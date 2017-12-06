package ArmasPack;

public abstract class Arma {

	private String nombre;
	private boolean magica;
	private boolean aDistancia;
	private int danho;
	
	public Arma (String nombre, boolean magica, boolean aDistancia, int danho){
		this.nombre = nombre;
		this.magica = magica;
		this.aDistancia = aDistancia;
		this.danho = danho;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isMagica() {
		return magica;
	}
	public void setMagica(boolean magica) {
		this.magica = magica;
	}
	public boolean isaDistancia() {
		return aDistancia;
	}
	public void setaDistancia(boolean aDistancia) {
		this.aDistancia = aDistancia;
	}
	public int getDanho() {
		return danho;
	}
	public void setDanho(int danhoFis) {
		this.danho = danhoFis;
	}

}
