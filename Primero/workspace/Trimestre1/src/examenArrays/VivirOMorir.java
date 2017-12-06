package examenArrays;

/**
 * Created by Alejandro on 11/12/2015.
 */
public class VivirOMorir {
    /*
        1.-Introduzco los datos.
        2.-Inicializo los arrays auxiliares
            2.1.-Hago una copia del array original en la función.
            2.2.-Inicializo el arrayActualizado a false.
        3.-Recorro la copia comprobando las células vivas alrededor.
            3.1.-Si encuentro una célula viva, entonces sumo un contador.
                3.1.1.-Compruebo la posición actual está viva o muerta y cambio a true si el contador está entre los rangos correspondientes.
        4.-Compruebo si ambos arrays son iguales o no hay células vivas o muertas.
        5.-El array copia para a ser igual que el array actualizado y sigo comprobando hasta que llegue al límite de los ciclos, sea igual, o queden todas las células muertas o vivas.
     */
    public static void main(String[] args) {
        int minv, maxv, mimm, maxm, ciclos;

        //1.-Introduzco los datos.

/*
        final boolean array[][] = {{true, false, false, false, true}, {false, false, false, true, false}, {true, false, true, true, false}, {false, true, false, false, false}, {true, true, false, false, false}};
        minv = 2;
        maxv = 5;
        mimm = 3;
        maxm = 6;
        ciclos = 9;

*/
        //final boolean array[][] = {{false, true, false, false, true}, {true, true, false, false, true}, {false, false, false, true, true}, {true, true, false, false, false}, {true, true, false, false, false}};
        //final boolean array[][] = {{true, true, true, true, true}, {true, true, true, true, true}, {true, true, true, true, true}, {true, true, true, true, true}, {true, true, true, true, true}};
        final boolean array[][] = {{false, false, false, false, false}, {false, false, true, false, false}, {false, true, false, false, false}, {false, false, false, false, false}, {false, false, false, false, false}};
        //minv = 2;
        minv = 0;
        maxv = 5;
        mimm = 2;
        maxm = 6;
        ciclos = 9;


        //imprimirArray(funcion(array, minv, maxv, mimm, maxm, ciclos));
        funcion(array, minv, maxv, mimm, maxm, ciclos);
    }

    public static boolean[][] funcion(boolean array[][], int minv, int maxv, int minm, int maxm, int ciclos) {
        boolean iguales;
        int i, j, contadorCiclo = 2, contadorParaVivir, aux;
        boolean arrayCopia[][] = new boolean[5][5];
        boolean arrayActualizado[][] = new boolean[5][5];

        //2.-Inicializo los arrays auxiliares
        //2.1.-Hago una copia del array original en la función.
        for (i = 0;  i < array.length; i++) {
            for (j = 0;  j < array[i].length; j++) {
                arrayCopia[i][j] = array[i][j];
            }
        }

        System.out.println("Instante 1");
        imprimirArray(arrayCopia);//Imprimo el primer instante.


        do {
            iguales = true;
            aux = 0;
            //2.2.-Inicializo el arrayActualizado a false.
            for (i = 0;  i < array.length; i++) {
                for (j = 0;  j < array[i].length; j++) {
                    arrayActualizado[i][j] = false;
                }
            }


            //3.-Recorro la copia comprobando las células vivas alrededor.
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    contadorParaVivir = 0;

                    //Compruebo si hay vivas cerca.
                    if (i + 1 < array.length && j - 1 >= 0) {//Compruebo que realmente haya una posición válida para comprobar en el primer if
                        if (arrayCopia[i + 1][j - 1] == true)//Este es el que compruebo si está viva o no.
                            contadorParaVivir++;//3.1.-Si encuentro una célula viva, entonces sumo un contador.
                    }

                    if (i + 1 < array.length) {
                        if (arrayCopia[i + 1][j] == true)
                            contadorParaVivir++;
                    }

                    if (i + 1 < array.length && j + 1 < array.length) {
                        if (arrayCopia[i + 1][j + 1] == true)
                            contadorParaVivir++;
                    }
                    if (j + 1 < array.length) {
                        if (arrayCopia[i][j + 1] == true)
                            contadorParaVivir++;
                    }

                    if (i - 1 >= 0 && j + 1 < array.length) {
                        if (arrayCopia[i - 1][j + 1] == true)
                            contadorParaVivir++;
                    }

                    if (i - 1 >= 0) {
                        if (arrayCopia[i - 1][j] == true)
                            contadorParaVivir++;
                    }

                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (arrayCopia[i - 1][j - 1] == true)
                            contadorParaVivir++;
                    }
                    if (j - 1 >= 0) {
                        if (arrayCopia[i][j - 1] == true)
                            contadorParaVivir++;
                    }


                    //3.1.1.-Compruebo la posición actual está viva o muerta y cambio a true si el contador está entre los rangos correspondientes.
                    if (arrayCopia[i][j] == true && contadorParaVivir > minv && contadorParaVivir < maxv)
                        arrayActualizado[i][j] = true;

                    else if (arrayCopia[i][j] == true && contadorParaVivir <= minv && contadorParaVivir >= maxv)
                        arrayActualizado[i][j] = false;

                    else if (arrayCopia[i][j] == false && contadorParaVivir > minm && contadorParaVivir < maxm)
                        arrayActualizado[i][j] = true;

                    else if (arrayCopia[i][j] == false && contadorParaVivir <= minm && contadorParaVivir >= maxm)
                        arrayActualizado[i][j] = false;

                }
            }


            //Comparo los arrays.
            for (i = 0;  i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    if (arrayActualizado[i][j] != arrayCopia[i][j])
                        iguales = false;
                }
            }


            //Copio el array actualizado en el array de la copia si no son iguales.
            for (i = 0;  i < array.length; i++)
                for (j = 0;  j < array[i].length; j++)
                    arrayCopia[i][j] = arrayActualizado[i][j];



            if (iguales == false) {
                System.out.printf("Instante %d%n", contadorCiclo);
                imprimirArray(arrayCopia);
            }
            contadorCiclo++;

        } while (contadorCiclo <= ciclos && !iguales);

        return arrayCopia;
    }

    public static void imprimirArray(boolean array[][]) {
        final String RESET = "\u001B[0m";
        final String VIVO = "\u001B[44m" + "  " + RESET;
        final String MUERTO = "\u001B[40m" + "  " + RESET;
        int i, j;
        for (i = 0;  i < array.length; i++) {
            for (j = 0;  j < array[i].length; j++) {
                if (array[i][j] == true)
                    System.out.printf("%s  ", VIVO);
                else
                    System.out.printf("%s  ", MUERTO);
            }
            System.out.printf("%n%n");
        }
    }
}
