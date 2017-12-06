package actions;

import personajes.Personaje;
import arena.Arena;

/**
 * Created by Alejandro on 08/04/2016.
 */
public class CombatirAction implements Action {
    private Personaje heroe;
    private Personaje villano;

    public CombatirAction(Personaje heroe, Personaje villano) {
        this.heroe = heroe;
        this.villano = villano;
    }

    public Object execute() {
        return new Arena().combate(heroe, villano);
    }
}
