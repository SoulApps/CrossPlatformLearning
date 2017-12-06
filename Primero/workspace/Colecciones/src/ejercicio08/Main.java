package ejercicio08;

import teclado.EnumRango;
import teclado.Teclado;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Alejandro on 24/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        int menu, i;
        String nombre;
        LinkedList<Empleado> empleados = new LinkedList<>();


        do {
            menu = Teclado.nextInt("¿Qué quieres hacer?\n" +
                    "1. Mostrar la lista de empleados\n" +
                    "2. Mostrar la lista de empleados al revés\n" +
                    "3. Buscar nombre de empleado\n" +
                    "4. Añadir empleado\n" +
                    "5. Salir", 1, 9, EnumRango.AMBOSINCLUIDOS);

            switch (menu) {
                case 1:
                    for (i = 0; i < empleados.size(); i++)
                        System.out.printf("%d.- %s", i, empleados.get(i));
                    break;
                case 2:
                    for (i = empleados.size(); i >= 0; i--)
                        System.out.printf("%d.- %s", i, empleados.get(i));
                    break;
                case 3:
                    nombre = Teclado.next("Introduce el nombre del empleado");
                    if (empleados.contains(new Empleado(nombre)))
                        System.out.println("Existe");
                    else
                        System.out.println("No existe");
                    break;
                case 4:
                    nombre = Teclado.next("Introdue el nombre del empleado");
                    if (empleados.isEmpty())
                        empleados.addLast(new Empleado(nombre));
                    break;
                case 5:
                    System.out.println("Adiós");
                    salir = true;
            }
        } while (!salir);
    }
}
