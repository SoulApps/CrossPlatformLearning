package personajes;

public class Guerrero extends Personaje{

	public Guerrero (String nombre,  int fuerzaAtaque, int fuerzaDefensa){
		
		super(nombre, fuerzaAtaque, fuerzaDefensa);
	}
	
	// El guerrero hace un daño del doble de su fuerza menos la defensa del enemigo
	
	public Personaje atacar(Personaje enemigo){
		enemigo.setVida(enemigo.getVida()-(2*getFuerzaAtaque()-enemigo.getFuerzaDefensa()));
		return enemigo;	
	}

}
