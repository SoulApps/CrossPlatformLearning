package ejercicio14;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Alfareria extends Producto implements Mercancia {

    private boolean esFragil;

    public Alfareria(double precio, String descripcion, boolean esFragil) {
        super(precio, descripcion);
        this.esFragil = esFragil;
    }
}
