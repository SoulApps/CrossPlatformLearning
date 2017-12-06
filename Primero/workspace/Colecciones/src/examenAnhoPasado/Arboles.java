package examenAnhoPasado;

import java.util.*;

/**
 * Created by Alejandro on 09/05/2016.
 */
public class Arboles {
    public static void main(String[] args) {
        //Declaración de variables
        GregorianCalendar alta = new GregorianCalendar(), baja = new GregorianCalendar();
        Empleado pepe, juan, maria, laura, esteban, pedro, yolanda, nuria, antonio, clonPepe, clonEsteban, clonPedro;
        TreeSet<Empleado> arbol1 = new TreeSet<Empleado>();
        TreeSet<Empleado> arbol2 = new TreeSet<Empleado>(new Comparator<Empleado>() {
                        public int compare(Empleado o1, Empleado o2) {
                            return o1.getNombre().compareTo(o2.getNombre());
                        }
                }
        );
        TreeMap<Clave, Empleado> arbol3 = new TreeMap<Clave, Empleado>(new ComparadorEmpleados());

        //Empleados
        alta.set(2011, 2, 21);
        baja.set(2013, 3, 22);
        pepe = new Empleado("Pepe", EnumCategoria.EMPLEADO, alta.getTime(), baja.getTime());

        alta.set(2012, 1, 29);
        juan = new Empleado("Juan", EnumCategoria.ENCARGADO, alta.getTime(), null);

        alta.set(2010, 3, 30);
        baja.set(2014, 4, 31);
        maria = new Empleado("María", EnumCategoria.JEFE, alta.getTime(), baja.getTime());

        alta.set(2010, 11, 30);
        laura = new Empleado("Laura", EnumCategoria.EMPLEADO, alta.getTime(), null);

        alta.set(2010, 10, 5);
        baja.set(2015, 1, 11);
        esteban = new Empleado("Esteban", EnumCategoria.ENCARGADO, alta.getTime(), baja.getTime());

        alta.set(2009, 7, 16);
        pedro = new Empleado("Pedro", EnumCategoria.JEFE, alta.getTime(), null);

        alta.set(2012, 6, 27);
        baja.set(2013, 9, 1);
        yolanda = new Empleado("Yolanda", EnumCategoria.EMPLEADO, alta.getTime(), baja.getTime());

        alta.set(2009, 7, 31);
        nuria = new Empleado("Nuria", EnumCategoria.JEFE, alta.getTime(), null);

        alta.set(2011, 0, 28);
        baja.set(2014, 4, 14);
        antonio = new Empleado("Antonio", EnumCategoria.ENCARGADO, alta.getTime(), baja.getTime());

        clonPepe = (Empleado) pepe.clone();
        clonEsteban = (Empleado) esteban.clone();
        clonPedro = (Empleado) pedro.clone();


        //Árbol 1
        System.out.println("---------------------------------------------------------------------ÁRBOL 1---------------------------------------------------------------------");
        arbol1.add(pepe);
        arbol1.add(juan);
        arbol1.add(maria);
        arbol1.add(laura);
        arbol1.add(esteban);
        arbol1.add(pedro);
        arbol1.add(yolanda);
        arbol1.add(nuria);
        arbol1.add(antonio);
        arbol1.add(clonPepe);
        arbol1.add(clonEsteban);
        arbol1.add(clonPedro);

        for (Empleado e:arbol1)
            System.out.println(e);

        //Arbol 2
        System.out.println("\n---------------------------------------------------------------------ÁRBOL 2---------------------------------------------------------------------");
        arbol2.add(pepe);
        arbol2.add(juan);
        arbol2.add(maria);
        arbol2.add(laura);
        arbol2.add(esteban);
        arbol2.add(pedro);
        arbol2.add(yolanda);
        arbol2.add(nuria);
        arbol2.add(antonio);
        arbol2.add(clonPepe);
        arbol2.add(clonEsteban);
        arbol2.add(clonPedro);

        for (Empleado e:arbol2)
            System.out.println(e);

        //Árbol 3
        System.out.println("\n---------------------------------------------------------------------ÁRBOL 3---------------------------------------------------------------------");
        arbol3.put(pepe.getClave(), pepe);
        arbol3.put(juan.getClave(), juan);
        arbol3.put(maria.getClave(), maria);
        arbol3.put(laura.getClave(), laura);
        arbol3.put(esteban.getClave(), esteban);
        arbol3.put(pedro.getClave(), pedro);
        arbol3.put(yolanda.getClave(), yolanda);
        arbol3.put(nuria.getClave(), nuria);
        arbol3.put(antonio.getClave(), antonio);
        arbol3.put(clonPepe.getClave(), clonPepe);
        arbol3.put(clonEsteban.getClave(), clonEsteban);
        arbol3.put(clonPedro.getClave(), clonPedro);

        for (Empleado e:arbol3.values())
            System.out.println(e);
    }
}
