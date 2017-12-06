package ejercicio06;

import teclado.EnumRango;
import teclado.Teclado;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Alejandro on 23/04/2016.
 */
public class Ejercicio06 {
    public static void main(String[] args) {
        boolean salir = false;
        int menu;
        byte dato;
        LinkedList<Byte> pila = new LinkedList<Byte>();
        ListIterator<Byte> it;

        do {
            menu = Teclado.nextInt("¿Qué quieres hacer?\n" +
                    "1. Nueva pila\n" +
                    "2. Consultar elemento\n" +
                    "3. Añadir elemento\n" +
                    "4. Eliminar elemento\n" +
                    "5. Consultar toda la pila\n" +
                    "6. Salir", 1, 6, EnumRango.AMBOSINCLUIDOS);

            switch (menu) {
                case 1:
                    pila.clear();
                    break;
                case 2:
                    if (pila.isEmpty())
                        System.out.println("La pila está vacía");
                    else
                        System.out.println(pila.getLast());
                    break;
                case 3:
                    dato = Teclado.nextByte("Introduce un número");
                    pila.addLast(dato);
                    break;
                case 4:
                    if (pila.isEmpty())
                        System.out.println("La pila está vacía");
                    else
                        pila.removeLast();
                    break;
                case 5:
                    if (pila.isEmpty())
                        System.out.println("La pila está vacía");
                    else {
                        it = pila.listIterator(pila.size());
                        while (it.hasPrevious()) {
                            System.out.println(it.previous());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Adiós");
                    salir = true;
            }
        } while (!salir);
    }
}
