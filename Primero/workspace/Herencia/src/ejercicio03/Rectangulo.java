package ejercicio03;

/**
 * Created by Alejandro on 26/01/2016.
 */
public class Rectangulo extends FiguraGeometrica {

    double base, altura;

    public Rectangulo(double x, double y, double base, double altura) {
        super(x, y);
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }
}
