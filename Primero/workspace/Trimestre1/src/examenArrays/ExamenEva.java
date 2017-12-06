package examenArrays;

import java.util.Arrays;

public class ExamenEva {
    /* 1. Realizar un bucle tantas veces como número de ciclos a realizar ó hasta cuándo
     * 		no haya cambios en ninguna célula.
     * 		1.1.Recorrer el array bidimensional
     *			1.1.1 Contar de las 8,5 ó 3 celdas colindantes cuántas células
     *				están vivas: realizar un bucle que recorra desde la fila anterior a la
     *				fila actual hasta la fila posterior a la fila actual.Anidarle un bucle
     *				que haga lo mismo pero con las columnas. Eso me dará las 9 combinaciones posibles
     *				de celdas. Descartar las siguientes combinaciones:
     *					- Celda actual
     *					- Celdas cuya fila es menor de 0 ó mayor a 5.
     *					- Celdas cuya columna es menor de 0 ó mayor de 5.
     *				1.1.1.1 Si la célula está viva en el instante t, comprobar si seguirá viva en el
     *					instante t+1:
     *				  	1.1.1.1.1 Si son más de minv y menos de maxv, entonces la célula seguirá viva.
     *				  	1.1.1.1.2 Si no, morirá.
     *				1.1.1.2 Si la célula está muerta en el instante t, comprobar si resucitará en t+1:
     *				  	1.1.1.2.1 Si son más de minm y menos de maxm, entonces la célula resucitará.
     *				  	1.1.1.2.2 Si no, seguirá muerta.
     *		2.1 Mostrar el array resultado
     */
    public static void main(String[] args) {
        boolean[][] resultado1,resultado2,resultado3;
        boolean[][] tablero1={{true,false,false,false,true},
                {false,false,false,true,false},
                {true,false,true,true,false},
                {false,true,false,false,false},
                {true,true,false,false,false}};
        boolean[][] tablero2={{false,true,false,false,true},
                {true,true,false,false,true},
                {false,false,false,true,true},
                {true,true,false,false,false},
                {true,true,false,false,false}};
        boolean[][] tablero3={{true,true,true,true,true},
                {true,true,true,true,true},
                {true,true,true,true,true},
                {true,true,true,true,true},
                {true,true,true,true,true}};
        System.out.println("VIVIR O MORIR: TABLERO1");
        resultado1=vivirMorir(tablero1,2,5,3,6,9);
        System.out.println("El array inicial del tablero1 es: ");
        imprimirTablero(tablero1);
        System.out.println("El resultado final del tablero1 es: ");
        imprimirTablero(resultado1);
        System.out.println("VIVIR O MORIR: TABLERO2");
        resultado2=vivirMorir(tablero2,2,5,2,6,9);
        System.out.println("El array inicial del tablero2 es: ");
        imprimirTablero(tablero2);
        System.out.println("El resultado final del tablero2 es: ");
        imprimirTablero(resultado2);
        System.out.println("VIVIR O MORIR: TABLERO3");
        resultado3=vivirMorir(tablero3,2,5,2,6,9);
        System.out.println("El array inicial del tablero3 es: ");
        imprimirTablero(tablero3);
        System.out.println("El resultado final del tablero3 es: ");
        imprimirTablero(resultado3);
    }
    public static void imprimirTablero(boolean[][] tablero){
        final String FONDO_NEGRO = "\u001B[40m";
        final String FONDO_CELESTE = "\u001B[46m";
        final String RESET = "\u001B[0m";
        final String ESPACIOS="  ";
        final char ESPACIO=' ';
        int i,j;
        for(i=0;i<tablero.length;i++){
            for(j=0;j<tablero[i].length;j++){
                if(tablero[i][j])
                    System.out.print(FONDO_CELESTE+ESPACIOS+RESET);
                else
                    System.out.print(FONDO_NEGRO+ESPACIOS+RESET);
                System.out.print(ESPACIO);
            }
            System.out.println();
            System.out.println();
        }
    }
    public static boolean[][] vivirMorir(boolean[][] tablero,int minv,int maxv,int minm,int maxm,int numCiclos){
        final int TAMANO=5;
        boolean[][] tableroSalida=new boolean[TAMANO][TAMANO];
        boolean[][] tableroAux=new boolean[TAMANO][];
        boolean cambios=true;
        int i,j,t,fila,columna,contador;
        //Mostrar el array inicial
        System.out.printf("Instante %d%n",1);
        imprimirTablero(tablero);
        //Se hace una copia del tablero en el tablero auxiliar para que el tablero sea exclusivamente de entrada y no se modifique
        for(i=0;i<TAMANO;i++)
            tableroAux[i]= Arrays.copyOf(tablero[i], TAMANO);
/*1. Realizar un bucle tantas veces como número de ciclos a realizar ó hasta cuándo
     no haya cambios en ninguna célula.*/
        for(t=2;t<=numCiclos && cambios;t++){
            cambios=false;
            //1.1. Recorrer el array bidimensional
            for(i=0;i<TAMANO;i++)
                for(j=0;j<TAMANO;j++){
/*				1.1.1 Contar de las 8,5 ó 3 celdas colindantes cuántas células
 *				están vivas: realizar un bucle que recorra desde la fila anterior a la
 *				fila actual hasta la fila posterior a la fila actual.Anidarle un bucle
 *				que haga lo mismo pero con las columnas. Eso me dará las 9 combinaciones posibles
 *				de celdas. Descartar las siguientes combinaciones:
 *					- Celda actual
 *					- Celdas cuya fila es menor de 0 ó mayor a 5.
 *					- Celdas cuya columna es menor de 0 ó mayor de 5.*/
                    contador=0;
                    for(fila=i-1;fila<=i+1;fila++)
                        for(columna=j-1;columna<=j+1;columna++)
                            if(fila>=0 && fila<TAMANO && columna>=0 && columna<TAMANO && !(fila==i && columna==j))//La última es para que no cuente la celda actual
                                if(tableroAux[fila][columna])//Si está viva
                                    contador++;
                    //1.1.1.1 Si la célula está viva en el instante t, comprobar si seguirá viva en el instante t+1:
                    if(tableroAux[i][j])
                        //1.1.1.1.1 Si son más de minv y menos de maxv, entonces la célula seguirá viva.
                        if(contador>minv && contador<maxv)
                            tableroSalida[i][j]=true;
                            //1.1.1.1.2 Si no, morirá.
                        else{ //Una célula viva ha muerto, por lo tanto ha habido algún cambio.
                            cambios=true;
                            tableroSalida[i][j]=false;
                        }
                        //1.1.1.2 Si la célula está muerta en el instante t, comprobar si resucitará en t+1:
                    else
                        //1.1.1.2.1 Si son más de minm y menos de maxm, entonces la célula resucitará.
                        if(contador>minm && contador<maxm){
                            tableroSalida[i][j]=true;
                            cambios=true;//Una célula muerta ha resucitado, por lo tanto ha habido algún cambio.
                        }
                        //1.1.1.2.2 Si no, seguirá muerta.
                        else
                            tableroSalida[i][j]=false;
                }
            //Se hace una copia del tablero de salida en el tablero auxiliar para la próxima iteración
            for(i=0;i<TAMANO;i++)
                for(j=0;j<TAMANO;j++)
                    tableroAux[i][j]=tableroSalida[i][j];
            //2.1 Mostrar el array resultado
            if(cambios){//Si no hay cambios no se muestra porque es igual a la anterior
                System.out.printf("Instante %d%n",t);
                imprimirTablero(tableroSalida);
            }
        }
        return tableroSalida;
    }
}
