package arrays;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio13 {
    public static void main(String[] args) {
        int array1[][][] = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}};
        int array2[][][] = new int[4][4][4];
        int i, j, k;
        String s = "";


        System.out.printf("Array1%n", s);
        for (i = 0; i < array1.length; i++) {
            for (j = 0; j < array1[i].length; j++) {
                for (k = 0; k < array1[i][j].length; k++) {
                    System.out.printf("%d%n", array1[i][j][k]);
                }
            }
        }
        for (i = 0; i < array1.length; i++) {
            for (j = 0; j < array1[i].length; j++) {
                for (k = 0; k < array1[i][j].length; k++)
                    array2[i][j][k] = array1[i][j][k];
            }
        }

        System.out.printf("%n%nArray2%n");
        for (i = 0; i < array2.length; i++) {
            for (j = 0; j < array2[i].length; j++) {
                for (k = 0; k < array2[i][j].length; k++)
                    System.out.println(array2[i][j][k]);
            }

        }
    }
}
