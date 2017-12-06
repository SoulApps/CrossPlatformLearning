package paquete;

/**
 * Created by Alejandro on 11/10/2016.
 */
public class Pepe extends Trabajador {

    Pila platosLimpios;
    Pila platosSecos;

    public Pepe(String nombre, Pila platosLimpios, Pila platosSecos) {
        super(nombre);
        this.platosLimpios = platosLimpios;
        this.platosSecos = platosSecos;
    }

    @Override
    public void run() {
        int i;
        for (i = 0; i < 50; i++)
            platosSecos.ponerPlato(platosLimpios.quitarPlato());
    }
}
