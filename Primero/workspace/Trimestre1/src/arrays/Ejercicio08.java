package arrays;

import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		
		int i, n;
		char c = 0, aux = 0, aux2 = 0;
		char array[] = new char [5];
        array[0] = 'a';
        array[1] = 'b';
        array[2] = 'c';
        array[3] = 'd';
		
		Scanner teclado = new Scanner(System.in);

        imprimirArrayChar(array);
        System.out.println("Char");
        c = teclado.next().charAt(0);
        System.out.println("Pos");
        n = teclado.nextInt();

        if (array[n] == 0)
            array[n] = c;

        else {
            for (i = n; i < array.length; i++) {
                if (i == n) {
                    aux = array[i];
                    array[n] = c;
                    array[i] = aux;
                    array[n] = c;
                }
                else {
                    aux2 = array[i];
                    array[i] = aux;
                    aux = aux2;
                }
            }
        }

        teclado.close();

        imprimirArrayChar(array);
	}
    public static void imprimirArrayChar(char array[]) {
        int i;
        for (i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
