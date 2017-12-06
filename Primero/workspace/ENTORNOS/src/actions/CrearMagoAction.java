package actions;

import personajes.Mago;

/**
 * Created by Alejandro on 08/04/2016.
 */
public class CrearMagoAction implements Action {
    private String nombre;
    private int fuerzaAtaque;
    private int fuerzaDefensa;
    private int destreza;

    public CrearMagoAction(String nombre, int fuerzaAtaque, int fuerzaDefensa, int destreza) {
        this.nombre = nombre;
        this.fuerzaAtaque = fuerzaAtaque;
        this.fuerzaDefensa = fuerzaDefensa;
        this.destreza = destreza;
    }

    public Object execute() {
        return new Mago(nombre, fuerzaAtaque, fuerzaDefensa, destreza);
    }
}
