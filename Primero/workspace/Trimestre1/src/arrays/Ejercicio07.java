package arrays;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio07 {
    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 5, i;
        System.out.println("Número main " + n);
        pasoValor(n);
        System.out.println("Número main " + n);
        System.out.println();
        for (i = 0; i < array.length; i++) {
            if (i == 0)
                System.out.printf("Elementos del array del main: %d", array[i]);
            else
                System.out.printf(", %d ", array[i]);
        }
        System.out.println();
        pasoReferencia(array);
        System.out.println();
        for (i = 0; i < array.length; i++) {
            if (i == 0)
                System.out.printf("Elementos del array del main: %d", array[i]);
            else
                System.out.printf(", %d ", array[i]);
        }
    }

    public static void pasoValor(int n) {
        n++;
        System.out.println("Número paso valor " + n);
    }

    public static void pasoReferencia(int array[]) {
        int i;
        for (i = 0; i < array.length; i++) {
            array[i] += 10;
            if (i == 0)
                System.out.printf("Elementos del array de la función: %d", array[i]);
            else
                System.out.printf(", %d ", array[i]);
        }
    }
}
