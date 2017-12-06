package ejercicio02;

import teclado.EnumRango;
import teclado.Teclado;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alejandro on 22/04/2016.
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        boolean salir = false, mostrado = false;
        int menu;
        ArrayList<Float> lista = new ArrayList<Float>();
        Iterator<Float> it;

        lista.add(3.14f);
        lista.add(20.14f);
        lista.add(1471905f);
        lista.add(1f);
        it = lista.iterator();

        do {
            menu = Teclado.nextInt("¿Qué quieres hacer?\n" +
                    "1. Mostrar la lista\n" +
                    "2. Mostrar siguiente\n" +
                    "3. Eliminar último mostrado\n" +
                    "4. Salir", 1, 4, EnumRango.AMBOSINCLUIDOS);
            switch (menu) {
                case 1:
                    mostrado = false;
                    if (lista.isEmpty())
                        System.out.println("Lista vacía");
                    else
                        for (Float f:lista)
                            System.out.println(f);
                    break;
                case 2:
                    if (lista.isEmpty())
                        System.out.println("La lista está vacía");
                    else {
                        if (!it.hasNext())
                            it = lista.iterator();

                        System.out.println(it.next());
                        mostrado = true;
                    }

                    break;
                case 3:
                    if (lista.isEmpty())
                        System.out.println("La lista está vacía");
                    else {
                        if (mostrado) {
                            it.remove();
                            mostrado = false;
                        }
                        else
                            System.out.println("No has mostrado nada");
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("Adiós");
            }
        } while (!salir);
    }
}
