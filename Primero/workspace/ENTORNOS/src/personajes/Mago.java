package personajes;

public class Mago extends Personaje{

	public Mago(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza){
		super(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
	
	}
	
	
	//El mago ataca la mitad de su fuerza menos la defensa de su enemigo
	
	public Personaje atacar(Personaje enemigo){
		if (getFuerzaAtaque() / 2 > enemigo.getFuerzaDefensa() && getDestreza() <= Math.random() * 100)
			enemigo.setVida(enemigo.getVida()-(getFuerzaAtaque()/2-enemigo.getFuerzaDefensa()));
		return enemigo;	
	}
}
