package actions;

import arena.Arena;
import personajes.Personaje;

public class CombateAction implements Action{
	
	Personaje heroe;
	Personaje villano;
	Arena arena;

		
	public CombateAction(Personaje heroe, Personaje villano){
		this.heroe=heroe;
		this.villano=villano;
	}
		
	public Object execute(){
		return arena.combate(heroe, villano);
	}
		
	public String toString(){
		return String.format("Se inicia el combate entre: %s y %s",heroe.toString(), villano.toString());
	}
}

