package personajes;

import variablesGlobales.GlobalValues;

public class Sanador extends Personaje{
	

	private Personaje sanador;

	public Sanador(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		super(nombre, fuerzaAtaque, fuerzaDefensa);
	
	}
	
	
	//El sanador ataca la cuarta parte de su fuerza menos la defensa de su enemigo
	
	
	
	public Personaje sanar(Personaje herido){
		herido.setVida(100);
		return herido;
		
	}
	
	public Personaje atacar(Personaje enemigo){
		enemigo.setVida(enemigo.getVida()-(getFuerzaAtaque()/4-enemigo.getFuerzaDefensa()));
		sanador.setVida(sanador.getVida()+(getFuerzaAtaque()*GlobalValues.roboVida/100));
		return enemigo;
	}
	
	
}
