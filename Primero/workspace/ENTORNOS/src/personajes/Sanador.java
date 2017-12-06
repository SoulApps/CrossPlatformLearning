package personajes;

import globalValues.GlobalValues;

public class Sanador extends Personaje{

	public Sanador(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza){
		super(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
	
	}
	
	
	//El sanador ataca la cuarta parte de su fuerza menos la defensa de su enemigo
	
	public Personaje atacar(Personaje enemigo){
		if (getFuerzaAtaque() / 4 > enemigo.getFuerzaDefensa() && getDestreza() >= Math.random() * 100) {
            setVida(getVida() + (getFuerzaAtaque() / 4 - enemigo.getFuerzaDefensa()) / GlobalValues.roboVida);
            enemigo.setVida(enemigo.getVida() - (getFuerzaAtaque() / 4 - enemigo.getFuerzaDefensa()));
        }
		return enemigo;	
	}
	
	public Personaje sanar(Personaje herido){
		herido.setVida(100);
		return herido;
		
	}

    //Main que prueba la curación al atacar.
    //Se curará cuando el ataque acierte.
    public static void main(String[] args) {
        Sanador s = new Sanador("S", 200, 10, 50); //El valor de destreza es 50.
        Sanador s2 = new Sanador("", 10, 10, 25);
        s.setVida(20);
        System.out.println(s);
        s.atacar(s2); //Se debería curar 4 (20+(200/4-10)/10) siendo 10 el "robo de vida".
        System.out.println(s);
    }
}
