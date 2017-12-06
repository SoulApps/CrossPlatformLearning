package ejercicio01;

import teclado.Teclado;

/**
 * Created by Alejandro on 14/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        Persona p3;
        Persona p4 = new Persona();


        //1.1
        p1.setNombre(Teclado.next("Introduce el nombre"));
        System.out.println(p1.getNombre());

        //1.2
        p1.setEdad(Teclado.nextInt("Introduce la edad"));
        System.out.println(p1.getEdad());
        p1.setAltura(Teclado.nextFloat("Introduce la altura"));
        System.out.println(p1.getAltura());
        p1.setOcupacion(Teclado.next("Introduce la ocupación"));
        System.out.println(p1.getOcupacion());

        //1.3
        System.out.printf("%n%nConstructor por defecto%n");
        System.out.println(p2.getNombre());
        System.out.println(p2.getEdad());
        System.out.println(p2.getAltura());
        System.out.println(p2.getOcupacion());

        //1.4
        System.out.printf("%n%nConstructor this%n");
        p3 = new Persona("Con nombre", 100, 1.80f, "Estudiante");
        System.out.println(p3.getNombre());
        System.out.println(p3.getEdad());
        System.out.println(p3.getAltura());
        System.out.println(p3.getOcupacion());

        //1.6
        System.out.printf("%n%nSueldo y tal%n");
        System.out.print("Sueldo actual: ");
        System.out.println(p4.getSueldo());
        System.out.print("Sueldo sumado: ");
        p3.setSueldo(1000.5f);
        p4.sumarSueldo(p3);
        System.out.println(p4.getSueldo());
        p4.doblarSueldo();
        System.out.print("Doblado: ");
        System.out.println(p4.getSueldo());

    }
}
