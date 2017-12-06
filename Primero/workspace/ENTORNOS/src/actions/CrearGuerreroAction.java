package actions;

import personajes.Guerrero;

/**
 * Created by Alejandro on 08/04/2016.
 */
public class CrearGuerreroAction implements Action {
    private String nombre;
    private int fuerzaAtaque;
    private int fuerzaDefensa;
    private int destreza;

    public CrearGuerreroAction(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza) {
        this.nombre = nombre;
        this.fuerzaAtaque = fuerzaAtaque;
        this.fuerzaDefensa = fuerzaDefensa;
        this.destreza = destreza;
    }

    public Object execute() {
        return new Guerrero(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
    }
}
