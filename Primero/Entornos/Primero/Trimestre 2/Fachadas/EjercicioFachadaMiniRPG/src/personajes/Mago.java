package personajes;

public class Mago extends Personaje{

	public Mago(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		super(nombre, fuerzaAtaque, fuerzaDefensa);
	
	}
	
	
	//El mago ataca la mitad de su fuerza menos la defensa de su enemigo
	
	public Personaje atacar(Personaje enemigo){
		enemigo.setVida(enemigo.getVida()-(getFuerzaAtaque()/2-enemigo.getFuerzaDefensa()));
		return enemigo;	
	}
}
