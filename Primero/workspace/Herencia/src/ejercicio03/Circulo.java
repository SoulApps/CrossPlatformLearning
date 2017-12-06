package ejercicio03;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Circulo extends FiguraGeometrica {

    double radio;

    public Circulo(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.pow(radio, 2) * Math.PI;
    }
}
