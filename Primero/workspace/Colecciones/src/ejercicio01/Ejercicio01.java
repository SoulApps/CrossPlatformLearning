package ejercicio01;

import teclado.EnumRango;
import teclado.Teclado;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alejandro on 22/04/2016.
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        boolean salir = false;
        int menu;
        ArrayList<String> lista = new ArrayList<String>();

        do {
            menu = Teclado.nextInt("¿Qué quieres hacer\n" +
                    "1. Nueva lista\n" +
                    "2. Número de cadenas\n" +
                    "3. Añadir cadena\n" +
                    "4. Eliminar cadena\n" +
                    "5. Contiene cadena\n" +
                    "6. Mostrar lista entera\n" +
                    "7. Salir", 1, 7, EnumRango.AMBOSINCLUIDOS);

            switch (menu) {
                case 1:
                    lista.clear();
                    break;
                case 2:
                    System.out.printf("El número actual de cadenas es de %d\n", lista.size());
                    break;
                case 3:
                    lista.add(Teclado.next("Introduce una cadena"));
                    break;
                case 4:
                    if (lista.isEmpty())
                        System.out.println("Lista vacía");
                    else
                        lista.remove(Teclado.next("Introduce la cadena que quieres eliminar"));
                    break;
                case 5:
                    if (lista.isEmpty())
                        System.out.println("Lista vacía");
                    else
                        System.out.println(lista.contains(Teclado.next("Introduce la cadena que quieres buscar"))?"Existe":"No existe");
                    break;
                case 6:
                    if (lista.isEmpty())
                        System.out.println("Lista vacía");
                    else
                        for (String s:lista)
                        System.out.println(s);
                    break;
                case 7:
                    System.out.println("Adiós");
                    salir = true;
            }
        } while (!salir);
    }
}
