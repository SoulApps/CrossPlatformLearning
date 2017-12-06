package arrays;

/**
 * Created by Alejandro on 27/11/2015.
 */
public class Ejercicio17 {
    public static void main(String[] args) {
        int array[] = {4, 2, 3, 1, 34, 54, 4536, 45445, 3, 1338, 2};
        //int array[] = {16,5,4,3,2,13};
        int i, aux;

        System.out.printf("Array inicial%n");
        for (i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.printf("%n%nArray ordenándose%n");


        for (i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1] && i + 1 < array.length) {
                aux = array[i+1];
                array[i+1] = array[i];
                array[i] = aux;
                for (i = 0; i < array.length; i++)
                    System.out.print(array[i] + " ");
                i = -1;//Lo vuelvo a cambiar a 0 para que vuelva a comprobarlo con el cambio hecho.
                System.out.println();
            }
        }

        /*
        for (i = 0; i < datos.length - 1; i++)
			//BUSCAMOS EL NUMERO MAYOR
			for (j = 0; j < datos.length - i - 1; j++)



				//MOVEMOS EL NUMERO SI ES MAYOR AL SIGUIENTE
				if (datos[j + 1] < datos[j]) {

					//EXPLICAMOS MOVIMIENTO
					System.out.printf("Movimiento %d.%d :%n  - %d avanza una posicion, dejando atras a %d %n", i+1, j+1, datos[j], datos[j + 1]);

					numSiguientePos = datos[j + 1];
					datos[j + 1] = datos[j];
					datos[j] = numSiguientePos;

					//MOSTRAMOS MOVIMIENTO REALIZADO
					for (k = 0; k < datos.length; k++)
						System.out.print(datos[k]+" ");
					System.out.println(" ");
				}
	}
         */

        System.out.printf("%nArray ordenado%n");
        for (i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

    }
}
