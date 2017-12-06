package facade.delegate;

import personajes.*;

/**
 * Created by Alejandro on 08/04/2016.
 */
public interface VerySuccesfulRPGFacadeDelegate {
    Guerrero crearGuerrero(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza);
    Mago crearMago(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza);
    Sanador crearSanador(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza);
    Personaje combatir(Personaje heroe, Personaje villano);
}
