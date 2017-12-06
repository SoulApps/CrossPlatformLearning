package arena;

import personajes.*;


public class Arena {

	public Personaje combate(Personaje heroe, Personaje villano){
		
		while (heroe.getVida()>0 && villano.getVida()>0){
		
			heroe.atacar(villano);
			if (villano.getVida()>0){
				villano.atacar(heroe);
			}
			
			/* For testing purposes */
			System.out.println("Heroe:"+heroe.toString());
			System.out.println("Villano:"+villano.toString());
			
		}	
		
		
		if (heroe.getVida()>villano.getVida()){
			return heroe;
		}
		
		return villano;
		
		
			
		}
		

	static public void main (String args[]){
		
		Mago mago = new Mago ("Merlin", 20,6);
		Guerrero guerrero = new Guerrero("Brutus", 8,2);
		Sanador sanador = new Sanador("Doctor", 15,4);
		Arena arena = new Arena();
		System.out.println("Victorioso:"+ arena.combate(mago, guerrero));
		
		
		
		
	}
	
	}
	
	

