package ejercicio03;

/**
 * Created by Alejandro on 08/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        FiguraGeometrica array[] = new FiguraGeometrica[3];
        array[0] = new Circulo(4, 5, 2);
        array[1] = new Rectangulo(2, 2, 2, 3);
        array[2] = new Triangulo(2, 3, 2, 2);

        for (i = 0; i < array.length; i++)
            System.out.printf("%s: %f%n", array[i].toString(), array[i].calcularArea());
    }
}
