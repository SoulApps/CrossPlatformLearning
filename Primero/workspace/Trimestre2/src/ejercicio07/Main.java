package ejercicio07;

/**
 * Created by Alejandro on 14/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        float alturaMaximaParaApilar = 10;
        Dimensiones caja1 = new Dimensiones(2, 1, 3);
        Dimensiones caja2 = new Dimensiones(2, 4, 6);

        System.out.println("Dimensiones de la caja 1: " + caja1);
        System.out.println("Dimensiones de la caja 2: " + caja2);

        System.out.println("Altura máxima para apilar de la caja 1: " + caja1.alturaMaximaParaApilar(alturaMaximaParaApilar));
        System.out.println("Suma de la x de las cajas 1 y 2: " + caja1.sumarDimensionesX(caja2));
        System.out.println("Suma de la y de las cajas 1 y 2: " + caja1.sumarDimensionesY(caja2));
        System.out.println("Suma de la z de las cajas 1 y 2: " + caja1.sumarDimensionesZ(caja2));
        System.out.println("Posibilidad para apilar paquetes: " + caja1.esPosibleApilarPaquetes(caja2, alturaMaximaParaApilar));

        caja1.voltearDimensionX();
        System.out.println("\nVoltear dimensionX: " + caja1);
        caja1.voltearDimensionY();
        System.out.println("Voltear dimensionY: " + caja1);
        caja1.voltearDimensionZ();
        System.out.println("Voltear dimensionZ: " + caja1);


        System.out.println("\n\nApilar paquetes");
        System.out.println(caja1.apilarPaquetes(caja2, alturaMaximaParaApilar));

        System.out.println(caja1);
        System.out.println(caja2);
    }
}
