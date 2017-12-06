package ejercicio06;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Forma formas[] = new Forma[4];

        formas[0] = new Circulo();
        formas[1] = new Cuadrado();
        formas[2] = new Triangulo();
        formas[3] = new Rombo();

        for (i = 0; i < formas.length; i++)
            System.out.println(formas[i].identidad());

    }
}
