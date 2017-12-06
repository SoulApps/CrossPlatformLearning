package facade;

import actions.Action;
import actions.CombateAction;
import actions.GuerreroAction;
import actions.MagoAction;
import actions.SanadorAction;
import facadeDelegate.RPGCutreFacadeDelegate;
import personajes.Guerrero;
import personajes.Mago;
import personajes.Personaje;
import personajes.Sanador;

public class RPGCutreFacade implements RPGCutreFacadeDelegate{
	
	public Guerrero crearGuerrero(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		Action action=new GuerreroAction(nombre, fuerzaAtaque, fuerzaDefensa);
		return (Guerrero)action.execute();
	}

	public Mago crearMago(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		Action action=new MagoAction(nombre, fuerzaAtaque, fuerzaDefensa);
		return (Mago)action.execute();
	}
	
	public Sanador crearSanador(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		Action action=new SanadorAction(nombre, fuerzaAtaque, fuerzaDefensa);
		return (Sanador)action.execute();
	}
	
	public Personaje combatir(Personaje heroe, Personaje villano){
		Action action=new CombateAction(heroe, villano);
		return (Personaje)action.execute();
	}
}
