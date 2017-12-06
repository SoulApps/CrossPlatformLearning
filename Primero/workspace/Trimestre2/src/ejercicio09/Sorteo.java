package ejercicio09;

import ejercicio08.Procesador;
import ejercicio08.Producto;
import teclado.EnumRango;
import teclado.Teclado;

import java.util.Random;

/**
 * Created by Alejandro on 15/01/2016.
 */
public class Sorteo {
    final int TAMANHO = 4;
    Producto sorteo[][] = null;

    public void organizarSorteo() {
        try {
            sorteo = new Producto[TAMANHO][TAMANHO];
            Producto p1, p2, p3, p4;
            p1 = new Producto("111-AAAA", Procesador.AMD, 1, 0);
            p2 = new Producto("222-BBBB", Procesador.AMD, 1, 0);
            p3 = new Producto("333-CCCC", Procesador.INTEL, 1, 0);
            p4 = new Producto("444-DDDD", Procesador.INTEL, 2, 0);
            colocar(p1);
            colocar(p2);
            colocar(p3);
            colocar(p4);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void mostrarSorteo() {
        int n, i, j;
        n = 0;
        for (i = 0; i < sorteo.length; i++) {
            for (j = 0; j < sorteo[i].length; j++) {
                n++;
                if (sorteo[i][j] != null)
                    System.out.println(n + ".-" + sorteo[i][j].getModelo());
            }
        }
        System.out.println();
    }

    public void sortear() {
        int n, i, j, suerte;
        suerte = Teclado.nextInt("Introduce un número", 1, 16, EnumRango.AMBOSINCLUIDOS) - 1;
        i = suerte / TAMANHO;
        j = suerte % TAMANHO;
        if (sorteo[i][j] != null) {
            System.out.printf("GANADOR%n%d.-%s%n", suerte, sorteo[i][j].getModelo());
            sorteo[i][j].disminuirStock();
            if (sorteo[i][j].getStock() == 0)
                sorteo[i][j] = null;
            else
                colocar(sorteo[i][j]);
            sorteo[i][j] = null;
        } else {
            System.out.println("No ha tenido suerte");
        }
    }

    public boolean comprobarSorteo() { //Se utiliza para comprobar que el array no esté vacío cuando no haya premios.
        int i, j;
        boolean noVacio = false;
        if (sorteo != null)
            for (i = 0; i < sorteo.length; i++)
                for (j = 0; j < sorteo[i].length; j++)
                    if (sorteo[i][j] != null)
                        noVacio = true;
        return noVacio;
    }

    private void colocar(Producto p) {
        int i, j;
        boolean otraVez;
        Random rnd = new Random();
        do {
            i = rnd.nextInt(4);
            j = rnd.nextInt(4);
            otraVez = true;
            if (sorteo[i][j] == null) {
                otraVez = false;
                sorteo[i][j] = p;
            }
        } while (otraVez);
    }
}
