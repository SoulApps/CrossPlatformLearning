package arrays;

import java.util.Random;

/**
 * Created by Alejandro on 03/12/2015.
 */
public class SopaLetras {
    //1.-Introduzco las palabras, posiciones y orientaciones en arrays diferentes
    //2.-Voy recorriendo los arrays de palabras, posi, posj y orientaciones.
    //2.1.Compruebo que no tenga espacios ni empiece por mayúsculas
    //2.2.-Coloco la palabra en las posiciones correctas y orientación correcta solo si cabe.
    //3.-Relleno los espacios en blanco.
    //3.1.-Genero un random para elegir si se introduce una min, may, ñ o Ñ.
    //3.2.-Genero otro random según la opción elegida.
    //4.-Imprimo la sopa totalmente rellena y lista.
    public static void main(String[] args) {
        //1.-Introduzco las palabras, posiciones y orientaciones en arrays diferentes
        char palabras[][] = {{'P', 'r', 'o', 'g', 'r', 'a', 'm', 'a', 'c', 'i', 'o', 'n'}, {'B', 'a', 's', 'e', 'D', 'e', 'D', 'a', 't', 'o', 's'},
                {'D', 'e', 's', 'a', 'r', 'r', 'o', 'l', 'l', 'o', 'I', 'n', 't', 'e', 'r', 'f', 'a', 'c', 'e', 's'}, {'M', 'a', 'r', 'c', 'a', 's'},
                {'A', 'c', 'c', 'e', 's', 'o', ' ', 'A', ' ', 'D', 'a', 't', 'o', 's'}, {'F', 'o', 'l'}, {'E', 'n', 't', 'o', 'r', 'n', 'o', 's'}, {'H', 'l', 'c'},
                {'A', 'n', 'd', 'r', 'o', 'i', 'd'}, {'S', 'i', 's', 't', 'e', 'm', 'a', 's'}, {'M', 'u', 'l', 't', 'i', 'h', 'i', 'l', 'o'}};

        EnumSopa sopita[] = {EnumSopa.ABAJODERECHA, EnumSopa.ARRIBADERECHA, EnumSopa.DERECHA, EnumSopa.IZQUIERDA, EnumSopa.IZQUIERDA, EnumSopa.ARRIBA,
                EnumSopa.DERECHA, EnumSopa.DERECHA, EnumSopa.ABAJOIZQUIERDA, EnumSopa.ABAJO, EnumSopa.ARRIBAIZQUIERDA};

        int posi[] = {4, 10, 15, 3, 0, 7, 0, 14, 6, 3, 15};
        int posj[] = {0, 4, 0, 12, 15, 2, 0, 14, 13, 5, 8};

        crearSopaLetras(palabras.length, palabras, sopita, posi, posj);
    }

    public static void crearSopaLetras(int longitud, char palabras[][], EnumSopa sopita[], int posi[], int posj[]) {
        char sopa[][] = new char[16][16];
        int i, j, k = 0, l, auxj;
        int cont;
        boolean b;
        String comprobarMayus, comprobarTildes;
        EnumSopa esopita;


        //2.-Voy recorriendo los arrays de palabras, posi, posj y orientaciones.
        while (k < palabras.length) {
            esopita = sopita[k];
            b = true;

            //2.1.Compruebo que no tenga espacios ni empiece por mayúsculas
            for (l = 0; l < palabras[k].length; l++) {
                comprobarMayus = "";
                comprobarTildes = "";
                comprobarMayus += palabras[k][0];
                comprobarTildes += palabras[k][l];
                if (palabras[k][l] == ' ' || comprobarTildes.matches("[.]*[ÁÉÍÓÚáéíóú]") || comprobarMayus.matches("[a-zñ]"))
                    b = false;
            }

            //2.2.-Coloco la palabra en las posiciones correctas y orientación correcta solo si cabe.
            if (b) {
                switch (esopita) {
                    case ABAJODERECHA:
                        if (sopa.length >= posi[k] + palabras[k].length && sopa.length >= posj[k] + palabras[k].length)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; i++, j++, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case ARRIBADERECHA:
                        if (palabras[k].length <= posi[k] + 1 && sopa.length >= posj[k] + palabras[k].length)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; i--, j++, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case DERECHA:
                        if (sopa.length >= posj[k] + palabras[k].length)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; j++, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case IZQUIERDA:
                        if (palabras[k].length <= posj[k] + 1)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; j--, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case ARRIBA:
                        if (palabras[k].length <= posi[k] + 1)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; i--, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case ABAJO:
                        if (sopa.length >= posi[k] + palabras[k].length)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; i++, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case ARRIBAIZQUIERDA:
                        if (palabras[k].length <= posi[k] + 1 && palabras[k].length <= posj[k] + 1)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; i--, j--, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                    case ABAJOIZQUIERDA:
                        if (sopa.length >= posi[k] + palabras[k].length && palabras[k].length <= posj[k] + 1)
                            for (cont = 0, i = posi[k], j = posj[k], auxj = 0; cont < palabras[k].length; i++, j--, auxj++, cont++)
                                sopa[i][j] = palabras[k][auxj];
                        break;
                }
            }
            k++;
        }

        //3.-Relleno los espacios en blanco. *Ver rellenar().
        for (i = 0; i < sopa.length; i++) {
            for (j = 0; j < sopa[i].length; j++) {
                if (sopa[i][j] == 0)
                    sopa[i][j] = rellenar();
            }
        }

        //4.-Imprimo la sopa totalmente rellena y lista.
        for (i = 0; i < sopa.length; i++) {
            System.out.printf("%-2d ", i);
            for (j = 0; j < sopa[i].length; j++) {
                System.out.printf(" %c ", sopa[i][j]);
            }
            System.out.println();
        }
        System.out.print("   ");
        for (i = 0; i < sopa.length; i++) {
            if (i > 9) {
                System.out.print(i + " ");
            }
            else
                System.out.print(" " + i + " ");
        }
    }

    public static char rellenar() {
        char letra = 0;
        int opcion;
        Random rnd = new Random();

        //3.1.-Genero un random para elegir si se introduce una min, may, ñ o Ñ.
        opcion = rnd.nextInt(3) + 1;
        //3.2.-Genero otro random según la opción elegida.
        switch (opcion) {
            case 1:
                letra = (char) (rnd.nextInt(26) + 97);//Min
                break;
            case 2:
                letra = (char) (rnd.nextInt(26) + 65);//May
                break;
            case 3:
                letra = 'ñ';//ñ
                break;
            case 4:
                letra = 'Ñ';//Ñ
                break;
        }
        return letra;
    }
}
