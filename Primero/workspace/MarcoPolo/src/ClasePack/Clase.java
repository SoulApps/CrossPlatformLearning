package ClasePack;

import ArmasPack.Arma;

public abstract class Clase {
	
	private String nombre;
	private boolean ranged;
	private boolean magico;
	protected int bonus = 30;
	
	public Clase (String nombre, boolean ranged, boolean magico){
		this.nombre = nombre;
		this.ranged = ranged;
		this.magico = magico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isRanged() {
		return ranged;
	}

	public void setRanged(boolean ranged) {
		this.ranged = ranged;
	}

	public boolean isMagico() {
		return magico;
	}

	public void setMagico(boolean magico) {
		this.magico = magico;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public abstract boolean comprobar (Arma arma);
	

}
