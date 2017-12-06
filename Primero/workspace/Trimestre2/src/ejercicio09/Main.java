package ejercicio09;

import ejercicio08.Procesador;
import ejercicio08.Producto;
import teclado.EnumRango;
import teclado.Teclado;

/**
 * Created by Alejandro on 04/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        int menu;
        boolean salir = false;
        Sorteo s = new Sorteo();
        try {
            Producto p1 = new Producto("111-AAAA", Procesador.AMD, 1, 0), p2 = new Producto("222-BBBB", Procesador.AMD, 1, 0), p3 = new Producto("333-CCCC", Procesador.INTEL, 1, 0), p4 = new Producto("444-DDDD", Procesador.INTEL, 2, 0);
        } catch (Exception e) {
            e.getMessage();
        }

        do {
            menu = Teclado.nextInt("1. Organizar sorteo\n2. Mostrar sorteo\n3. Sorteo\n4. Salir", 1, 4, EnumRango.AMBOSINCLUIDOS);
            switch (menu) {
                case 1:
                    s.organizarSorteo();
                    break;
                case 2:
                    if (s.comprobarSorteo())
                        s.mostrarSorteo();
                    else
                        System.out.println("El sorteo no ha sido organizado");
                    break;
                case 3:
                    if (s.comprobarSorteo())
                        s.sortear();
                    else
                        System.out.println("El sorteo no ha sido organizado");
                    break;
                case 4:
                    salir = true;
                    break;
            }
        } while (!salir);
    }
}
