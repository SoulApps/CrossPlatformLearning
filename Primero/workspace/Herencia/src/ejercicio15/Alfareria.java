package ejercicio15;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Alfareria extends Producto implements MercanciaFragil {

    private boolean esFragil;
    private String embalaje;
    private double peso;

    public Alfareria(double precio, String descripcion, boolean esFragil, String embalaje, double peso) {
        super(precio, descripcion);
        this.esFragil = esFragil;
        this.embalaje = embalaje;
        this.peso = peso;
    }

    public String dameEmbalaje() {
        return embalaje;
    }


    public double damePeso() {
        return peso;
    }
}
