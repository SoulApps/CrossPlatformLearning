package personajes;

public class Sanador extends Personaje{

	public Sanador(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		super(nombre, fuerzaAtaque, fuerzaDefensa);
	
	}
	
	
	//El sanador ataca la cuarta parte de su fuerza menos la defensa de su enemigo
	
	public Personaje atacar(Personaje enemigo){
		enemigo.setVida(enemigo.getVida()-(getFuerzaAtaque()/4-enemigo.getFuerzaDefensa()));
		return enemigo;	
	}
	
	public Personaje sanar(Personaje herido){
		herido.setVida(100);
		return herido;
		
	}
}
