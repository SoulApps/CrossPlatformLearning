package arrays;

/**
 * Created by Alejandro on 26/11/2015.
 */
public class Ejercicio14 {
    public static void main(String[] args) {
        boolean sim = false;
        int i, j;
        int array[][] = {{1, 2, 3, 4}, {2, 5, 6, 7}, {3, 6, 8, 9}, {4, 7, 9, 10}};

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }

            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    if (array[i][j] != array[j][i])
                        sim = true;
                }
            }

        if (!sim)
            System.out.println("Es simétrico");
        else
            System.out.println("No es simétrico");
    }
}
