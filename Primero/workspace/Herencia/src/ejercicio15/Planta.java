package ejercicio15;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Planta extends Producto implements MercanciaViva {

    private boolean estaRegada;
    private boolean necesitaComida;
    private boolean necesitaRiego;

    public Planta(double precio, String descripcion, boolean estaRegada, boolean hambre, boolean necesitaRiego) {
        super(precio, descripcion);
        this.estaRegada = estaRegada;
        this.necesitaComida = hambre;
        this.necesitaRiego = necesitaRiego;
    }

    public boolean necesitaComida() {
        return necesitaComida;
    }

    public boolean necesitaRiego() {
        return necesitaRiego;
    }
}
