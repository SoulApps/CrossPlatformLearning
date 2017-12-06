package ejercicio03;

/**
 * Created by Alejandro on 26/01/2016.
 */
public abstract class FiguraGeometrica {
    protected double x, y;

    public FiguraGeometrica(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double calcularArea();

    public String toString() {
        String nombre = "";
        if ((this) instanceof Circulo)
            nombre = "Círculo";
        else if((this) instanceof Rectangulo)
            nombre = "Rectángulo";
        else if ((this) instanceof Triangulo)
            nombre = "Triángulo";
        return nombre;
    }
}
