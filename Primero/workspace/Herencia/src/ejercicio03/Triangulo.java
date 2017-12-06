package ejercicio03;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Triangulo extends FiguraGeometrica {

    double base, altura;

    public Triangulo(double x, double y, double base, double altura) {
        super(x, y);
        this.base = base;
        this.altura = altura;
    }


    public double calcularArea() {
        return base * altura / 2;
    }
}
