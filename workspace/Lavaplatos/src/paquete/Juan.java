package paquete;

/**
 * Created by Alejandro on 11/10/2016.
 */
public class Juan extends Trabajador {

    Pila platosSecos;

    public Juan(String nombre, Pila platosSecos) {
        super(nombre);
        this.platosSecos = platosSecos;
    }

    @Override
    public void run() {
        int i;
        for (i = 0; i < 50; i++)
            platosSecos.quitarPlato();
    }
}
