package ejercicio14;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Planta extends Producto implements Mercancia {

    private boolean estaRegada;

    public Planta(double precio, String descripcion, boolean estaRegada) {
        super(precio, descripcion);
        this.estaRegada = estaRegada;
    }
}
