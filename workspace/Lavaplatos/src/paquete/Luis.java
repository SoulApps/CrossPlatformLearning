package paquete;

/**
 * Created by Alejandro on 11/10/2016.
 */
public class Luis extends Trabajador {

    private Pila platosLimpios;

    public Luis(String nombre, Pila platosLimpios) {
        super(nombre);
        this.platosLimpios = platosLimpios;
    }

    @Override
    public void run() {
        int i;
        for (i = 0; i < 50; i++) {
            platosLimpios.ponerPlato(i);
        }
    }
}
