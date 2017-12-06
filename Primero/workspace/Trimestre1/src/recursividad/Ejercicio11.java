package recursividad;

import teclado.Teclado;

/**
 * Created by Alejandro on 13/11/2015.
 */
public class Ejercicio11 {
    public static void main(String[] args) {
        int numberUsure,j=0,result2,valueNumberSF=0;
        boolean fail=false,exit=false;

        System.out.printf("\tLA SERIE DE FIBONACCI RECURSIVO COMPARANDO CON UN VALOR USUARIO");
        do{//--------------------------------------------------------------> 1.Pedir al usuario el número entero.
            numberUsure = Teclado.nextInt("Introduzca un valor: ");
            fail=false;

            if(numberUsure<0){//Mensaje de error.
                System.out.printf("Error");
                fail=true;
            }
        }while(fail);
        Teclado.pichita();//Fin de entrada de datos.

        //2.Comparar el valor usuario con la serie fibonacci. NO SE HACE EL FOR AUNQUE TE VALGA YA QUE NO SE SABE CUANDO TERMINARA.
        do {
            result2=Ejercicio10.fibonacci(j);//Calculamos fibonacci de j, que esta inicializado en 0.
            //2.2 Si es mayor o igual para las comparaciones.//2.1 Si es menor seguir sacando valores.
            if (result2>=numberUsure){//Si el número calculado de la serie es mayor que el introducido por teclado, lo mostramos y cerramos el bucle.
                System.out.printf("%n %s Valor introducido por el usuario: %d.%n %1$s Resultado final de la serie de fibonacci: %d.");//3.Resepresentar resultado.
                valueNumberSF=j;
                exit=true;
            }
            j++;//Si no salimos del bucle porque salir = true entonces incrementamos j.

        }while(!exit);//Se hace hasta que j sea menor o igual que num o salir sea true.

    }
}
