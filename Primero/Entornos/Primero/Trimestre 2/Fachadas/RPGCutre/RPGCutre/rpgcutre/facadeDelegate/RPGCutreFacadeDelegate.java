package facadeDelegate;

import personajes.Guerrero;
import personajes.Mago;
import personajes.Personaje;
import personajes.Sanador;

public interface RPGCutreFacadeDelegate {
	
	Guerrero crearGuerrero(String nombre, int fuerzaAtaque, int fuerzaDefensa);
	Mago crearMago(String nombre, int fuerzaAtaque, int fuerzaDefensa);
	Sanador crearSanador(String nombre, int fuerzaAtaque, int fuerzaDefensa);
	Personaje combatir(Personaje heroe, Personaje villano);

}
