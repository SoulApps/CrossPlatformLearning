package arrays;

import teclado.Teclado;

import java.util.Arrays;

/*Escribe un programa que inicialice una matriz de NxN desde teclado y que diga si existe
alguna fila exactamente igual a alguna columna, junto con los �ndices de las filas y columnas
que son iguales.
1. Pedir al usuario el tama�o del array y este para ser simetrico debe ser una matriz cuadrada
2. Declaro la matriz
3. Relleno la matriz con elementos pedidos por el usuario
4. Visualizo la matriz por pantalla con una funcion
5. Mando mi matriz a la funcion FilaIgualColumna
*/
public class Ejercicio16 {

    public static void main(String[] args) {
        int fila, columna;
        int a[][];
        // 1. Pedir al usuario el tama�o de las filas y columnas y ademas que sea una matriz cuadrada es decir fila=columnas
        do {
            fila = Teclado.nextInt("Introduce el numero de filas de la matriz ");//Utilizo mi clase teclado para que el usuario solo me meta enteros
            columna = Teclado.nextInt("Introduce el numero de columnas de la matriz ");
        }
        while (fila <= 0 && columna <= 0 && fila == columna);//Controlo que el tama�o tanto de la fila como la columna no sea negativo ni 0 pk no tiene sentido

        //2. Declaro la matriz
        a = new int[fila][columna];//por ser cuadrada me valdria usar solo una variable

        //3. Relleno la matriz con elementos pedidos por el usuario
        for (int i = 0; i < fila; i++) {

            for (int j = 0; j < columna; j++) {
                a[i][j] = Teclado.nextInt("Introduce un valor para la celda de la fila: " + i + " columna: " + j);
            }
        }
        //4. Visualizo la matriz por pantalla con una funcion que ya he usado en todos los ejercicios
        VisualizarMatrices(a, fila, columna);

        //5. Mando mi matriz a la funcion FilaIgualColumna
        FilaIgualColumna(a, fila, fila);


    }

    //Construyo una funcion que visualiza la matriz incluyendo los indices de la misma
    public static void VisualizarMatrices(int[][] a, int fila, int columna) {
        int i, j, k;
        for (i = 0; i < fila; i++) {//recorro las filas del array desde la posicion 0 hasta el final
            System.out.print(i);//imprimo cada vez la fila en la que me encuentro
            for (j = 0; j < columna; j++) {//recorro para cada fila la columnas desde la posicion 0 hasta el final
                System.out.print(" [" + a[i][j] + "]");//imprimo por pantalla para cada fila cada una de las columnas

            }
            System.out.println();//cuando finalizo el bucle de las columnas salto de linea porque comienza una fila nueva
        }//fin de la matriz
        for (k = 0; k < columna; k++)//bucle que imprime la ultima fila donde se registran las posiciones de las columnas
            System.out.print("   " + k);
    }

    public static void FilaIgualColumna(int[][] a, int fila, int columna) {
        int k, i, j, poscol = 0, posfil = 0, n;//variables locales del programa son variables de bucle y de guardar posicion ademas de la booleana de control para cuando sea coincidente
        boolean control = true;
        for (k = 0; k < a.length && control; k++) {//Lo que hago es crear un vector que va a representar un array unidimensional con los mismos elementos que tiene una fila
            //de mi matriz
            int b[] = Arrays.copyOf(a[k], a[k].length);
            posfil = k;//registro esa fila su posicion por si fuera igual poder mostrarla
            for (i = 0; i < a.length && control; i++) {//Recorro mi matriz fila y columna
                n = 0;//variable que resetea cuando se termina de comparar una columna
                for (j = 0; j < a[i].length && control; j++) {
                    if (a[j][i] == b[j]) {//comparo un elemento de dicha columna con la fila
                        n++;//incremento por cada coincidencia
                        poscol = i;//registro esa columna en una variable porque despues si coincide se mostrara por pantalla
                    }
                    if (n == b.length) {//cuando ese contador sea igual al numero de elementos es decir que tenga por ejemplo 3 elementos iguales y es cantidad es igual al numero de elementos del vecto
                        control = false;//Tenemos una variable de control que cuando ocurra esto saldra de todos los bucles de ahi que tengan la condicion de control en todos

                    }

                }
            }
        }
        if (control) {//Si se mantiene la variable de control a true es pk ninguna es igual
            System.out.println("La matriz no tiene ninguna fila ni columna iguales");

        } else {//sino pues resulta que se cumple que son iguales pk ha salido de los bucles y tenemos registrado tanto la posicion de la fila como de la columna
            System.out.printf("La matriz tiene la fila %d identica que la columna %d", posfil, poscol);
            ;
        }
    }
/*Para hacer pruebas sin necesidad de ir copiando los elementos
 int [][] numeros = {{4,1,5}, {1, 2, 8}, {6,3,9}};
		int n=0,poscol=0,i,j,k,posfil = 0;
		boolean control=true;
		
		
		for ( i = 0; i < numeros.length; i++) {  //n�mero de filas
		     for ( j = 0; j < numeros[i].length; j++) { //n�mero de columnas de cada fila
		          System.out.print(numeros[i][j] + " ");
		     }
		     System.out.println();
		}
		
		for( k=0;k<numeros.length&&control;k++){
			int b[]=Arrays.copyOf(numeros[k], numeros[k].length);
			posfil=k;
			for( i=0;i<numeros.length&&control;i++){
				n=0;
				for( j=0;j<numeros[i].length&&control;j++){
					if(numeros[j][i]==b[j]){
						n++;
						poscol=i;
					}
					if(n==b.length){
						control=false;
						
					}
					
				}
			}
		}
		if(control){
			System.out.println("La matriz no tiene ninguna fila ni columna iguales");
			
		}else{
			System.out.printf("La matriz tiene la fila %d identica que la columna %d",posfil,poscol);;
		}
		*/

}
