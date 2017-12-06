package personajes;

public class Guerrero extends Personaje{

	public Guerrero (String nombre,  int fuerzaAtaque, int fuerzaDefensa, int destreza){
		
		super(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
	}
	
	// El guerrero hace un da�o del doble de su fuerza menos la defensa del enemigo
	
	public Personaje atacar(Personaje enemigo){
		if (2 * getFuerzaAtaque() > enemigo.getFuerzaDefensa() && getDestreza() <= Math.random() * 100)
			enemigo.setVida(enemigo.getVida()-(2*getFuerzaAtaque()-enemigo.getFuerzaDefensa()));
		return enemigo;	
	}

}
