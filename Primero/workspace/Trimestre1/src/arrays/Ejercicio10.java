package arrays;

/**
 * Created by Alejandro on 12/11/2015.
 */
public class Ejercicio10 {
    /**Realiza una funci�n recursiva que calcule si un array unidimensional de n�meros es capic�a.*/
    public static void main(String[] args) {

        /**DECLARAMOS VARIABLES Y OBJETOS*/
        int datos [] = {3,2,1,3};
        boolean capicuo=false;

        /**COMPROBAMOS SI ES CAPICUO*/
        capicuo= capicua(datos, 0);
        if(capicuo == false)
            System.out.println("Los numeros no son capicuos.");
        else
            System.out.println("Los numeros si son capicuos");

    }
    public static boolean capicua(int datos[], int pos) {

        //CASO BASE, SI NO ENTRA EN NINGUN IF DA FALSO
        boolean resultado = false;

        /**COMPROBAMOS SI EL ARRARY ES CAPICUO*/
        // LLega a la mitad, entonces es capicUa (para saber cuando parar)
        if (datos.length / 2 == pos)// CASO BASE SI LLEGA A LA MITAD
            resultado = true;

            // COMPROBAMOS SI LA PRIMERA POSICION CORRESPONDE CON LA �LTIMA
        else if (datos[pos] == datos[datos.length - pos - 1])
            // Si se corresponden, volvemos a llamar a la funci�n con los
            // siguientes param�tros
            resultado = capicua(datos, pos + 1);

        /**DEVOLVEMOS RESULTADO*/
        return resultado;
    }
}
