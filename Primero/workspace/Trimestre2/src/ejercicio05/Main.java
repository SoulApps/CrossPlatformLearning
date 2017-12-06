package ejercicio05;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        Alimento a = new Alimento("Patata");
        Alimento b = new Alimento("Col de bruselas", 20, 65, 12.5f, true, Nivel.ALTO, Nivel.ALTO);

        System.out.println("a");
        System.out.println(a);
        if (a.esDietetico())
            System.out.println("Es dietético");
        else
            System.out.println("No es dietético");

        if (a.esRecomendableParaDeportistas())
            System.out.println("Es recomendable para deportistas");
        else
            System.out.println("No es recomendable para deportistas");


        System.out.println();


        System.out.println("b");
        System.out.println(b);
        if (b.esDietetico())
            System.out.println("Es dietético");
        else
            System.out.println("No es dietético");

        if (b.esRecomendableParaDeportistas())
            System.out.println("Es recomendable para deportistas");
        else
            System.out.println("No es recomendable para deportistas");


        System.out.println(b.calculaContenidoEnergetico() + " kcal");

    }
}
