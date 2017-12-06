package personajes;

public abstract class Personaje {
	
	private int fuerzaAtaque;
	private int fuerzaDefensa;
	private String nombre;
	private int vida;
	
	public Personaje(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		this.fuerzaAtaque=fuerzaAtaque;
		this.fuerzaDefensa=fuerzaDefensa;
		this.nombre=nombre;
		vida = 100;
		
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getFuerzaAtaque() {
		return fuerzaAtaque;
	}
	public void setFuerzaAtaque(int fuerzaAtaque) {
		this.fuerzaAtaque = fuerzaAtaque;
	}
	public int getFuerzaDefensa() {
		return fuerzaDefensa;
	}
	public void setFuerzaDefensa(int fuerzaDefensa) {
		this.fuerzaDefensa = fuerzaDefensa;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String toString(){
		return "Nombre: "+nombre+" At:"+fuerzaAtaque+" Df:"+fuerzaDefensa+" vida ="+vida;
		
		
	}
	
	
	public abstract  Personaje atacar (Personaje enemigo);
	
	
	
	
}

