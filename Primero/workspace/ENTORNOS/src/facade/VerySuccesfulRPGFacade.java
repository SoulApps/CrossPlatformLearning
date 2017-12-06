package facade;

import actions.*;
import facade.delegate.VerySuccesfulRPGFacadeDelegate;
import personajes.*;

/**
 * Created by Alejandro on 08/04/2016.
 */
public class VerySuccesfulRPGFacade implements VerySuccesfulRPGFacadeDelegate {

    public Guerrero crearGuerrero(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza) {
        Action action = new CrearGuerreroAction(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
        return (Guerrero) action.execute();
    }


    public Mago crearMago(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza) {
        Action action = new CrearMagoAction(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
        return (Mago) action.execute();
    }


    public Sanador crearSanador(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza) {
        Action action = new CrearSanadorAction(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
        return (Sanador) action.execute();
    }


    public Personaje combatir(Personaje heroe, Personaje villano) {
        Action action = new CombatirAction(heroe, villano);
        return (Personaje) action.execute();
    }


    public static void main(String[] args) {
        VerySuccesfulRPGFacadeDelegate fachada = new VerySuccesfulRPGFacade();
        Sanador s;
        Guerrero g;

        s = fachada.crearSanador("Sanador", 500, 25, 60);
        g = fachada.crearGuerrero("Jerrero", 80, 50, 70);
        System.out.println("Victorioso: " + fachada.combatir(s, g)); //El guerrero perderá.

        //Prueba de sanar.
        s.sanar(g);
        System.out.println(g);
    }
}
