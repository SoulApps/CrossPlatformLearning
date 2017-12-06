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
		
		//Batalla
		System.out.println("---BATALLA---");
		Mago mago = new Mago ("Merlin", 20,6);
		Guerrero guerrero = new Guerrero("Brutus", 8,2);
		Arena arena = new Arena();
		System.out.println("Victorioso:"+ arena.combate(mago, guerrero));
		
		
		
		//Prueba de sanador
		System.out.printf("%n%n%n---PRUEBA DE SANAR---%n");
		Sanador sanador = new Sanador("Doctor", 15,4);
		sanador.setVida(80);
		System.out.println("Vida actual: "+sanador.getVida());
		System.out.println(sanador.sanar(sanador));
		
		
		
	}
	
	}
	
	

