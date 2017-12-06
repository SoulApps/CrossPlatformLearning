package ejercicio12;

import teclado.EnumLimite;
import teclado.EnumRango;
import teclado.Teclado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Alejandro on 07/05/2016.
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        boolean salir = false;
        TreeSet<Animal> arbol = new TreeSet<Animal>();
        Animal gato = null, loro = null, perro = null, perro2 = null, perro3 = null, gato2 = null;
        try {
            gato = new Gatos("Gatete1", 25, "Neko", "Shampoo del bueno", false, formato.parse("01/01/2001"));
            gato.criar("CriaGato1", "26/05/2021");
            loro = new Loros("Lorito1", 25, "Monstruo de las galletas", Alimentacion.HERBIVORAS, false, formato.parse("02/01/2001"));
            loro.criar("CriaLoro1", "15/06/1999");
            perro = new Perros("Perraco1", 25, "Wan-chan", "Suave y sedoso de guaurnier", false, 9, formato.parse("03/01/2001"));
            perro2 = new Perros("Perraco2", 25, "Wan-chan", "Suave y sedoso de guaurnier", false, 9, formato.parse("04/01/2001"));
            perro3 = new Perros("Perraco3", 25, "Wan-chan", "Suave y sedoso de guaurnier", false, 9, formato.parse("05/01/2001"));
            gato2 = new Gatos("Gatete2", 25, "Neko", "Shampoo del bueno", false, formato.parse("06/01/2001"));
        } catch (ParseException e) {

        }

        arbol.add(gato);
        arbol.add(loro);
        arbol.add(perro);
        arbol.add(perro2);
        arbol.add(perro3);
        arbol.add(gato2);

        do {
            switch (Teclado.nextInt("¿Qué quieres hacer?\n1. Nuevo árbol\n2. Añadir animal\n3. Mostrar el más pequeño\n4. Mostrar el mayor\n5. Mostrar árbol\n6. Mostrar subárbol\n7. Salir", 1, 7, EnumRango.AMBOSINCLUIDOS)) {
                case 1:
                    arbol.clear();
                    System.out.println("SE HA LIMPIADO EL ÁRBOL");
                    break;
                case 2:
                    anhadirAnimal(arbol);
                    break;
                case 3:
                    if (!arbol.isEmpty())
                        System.out.println(arbol.first());
                    else
                        System.out.println("EL ÁRBOL ESTÁ VACÍO");
                    break;
                case 4:
                    if (!arbol.isEmpty())
                        System.out.println(arbol.last());
                    else
                        System.out.println("EL ÁRBOL ESTÁ VACÍO");
                    break;
                case 5:
                    mostrarArbol(arbol);
                    break;
                case 6:
                    mostrarSubArbol(arbol);
                    break;
                case 7:
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    public static void anhadirAnimal(TreeSet<Animal> arbol) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        boolean esMamifero, esPerroLoro, enfadado, habla;
        String nombre, raza, champu, fecha;
        byte agresividad, alimentacionAux;
        double cuota;
        Alimentacion alimentacion = null;
        Animal animal = null;

        esMamifero = Teclado.nextBoolean("¿Qué es su mascota?", "Mamífero", "Ave");
        fecha = Teclado.next("¿Cuándo nació su mascota?");

        if (esMamifero)
            esPerroLoro = Teclado.nextBoolean("¿Qué tipo de mamífero es su mascota?", "Perro", "Gato");
        else
            esPerroLoro = Teclado.nextBoolean("¿Qué tipo de ave es su mascota?", "Loro", "Periquito");

        nombre = Teclado.next("¿Cómo se llama su mascota?");
        raza = Teclado.next("¿Cuál es su raza?");
        cuota = Teclado.nextDouble("¿Cuánto cree usted que vale pasar una noche en esta clínica de 5 peztrellas?", 0, EnumLimite.MAYOR);

        if (esMamifero) {
            champu = Teclado.next("¿Qué champú usa su mascota?");
            enfadado = Teclado.nextBoolean("¿Está enfadada su mascota?", "Sí", "No");
            if (esPerroLoro) {
                agresividad = Teclado.nextByte("¿Cómo de agresivo es su perro? (0-100)", (byte) 0, (byte) 100, EnumRango.AMBOSINCLUIDOS);
                try {
                    animal = new Perros(nombre, cuota, raza, champu, enfadado, agresividad, formato.parse(fecha));
                } catch (ParseException e) {

                }
                arbol.add(animal);
            } else {
                try {
                    animal = new Gatos(nombre, cuota, raza, champu, enfadado, formato.parse(fecha));
                } catch (ParseException e) {

                }
                arbol.add(animal);
            }
        } else {
            alimentacionAux = Teclado.nextByte("¿Qué tipo de alimentación lleva su mascota? 1.-Insectívora 2.-Herbívora 3.-Omnívora 4.-Carnívora", (byte) 1, (byte) 4, EnumRango.AMBOSINCLUIDOS);
            switch (alimentacionAux) {
                case 1:
                    alimentacion = Alimentacion.INSECTIVORAS;
                    break;
                case 2:
                    alimentacion = Alimentacion.HERBIVORAS;
                    break;
                case 3:
                    alimentacion = Alimentacion.OMNIVORAS;
                    break;
                case 4:
                    alimentacion = Alimentacion.CARNIVORAS;
                    break;
            }

            if (esPerroLoro) {
                habla = Teclado.nextBoolean("¿Habla su mascota?", "Sí", "No");
                try {
                    animal = new Loros(nombre, cuota, raza, alimentacion, habla, formato.parse(fecha));
                } catch (ParseException e) {

                }
                arbol.add(animal);
            } else {
                try {
                    animal = new Periquitos(nombre, cuota, raza, alimentacion, formato.parse(fecha));
                } catch (ParseException e) {

                }
                arbol.add(animal);
            }
        }
        System.out.println("Mascota añadida");
    }

    public static void mostrarArbol(TreeSet<Animal> arbol) {
        if (!arbol.isEmpty())
            for (Animal a : arbol)
                System.out.println(a);
        else
            System.out.println("EL MAPA ESTÁ VACÍO");
    }

    public static void mostrarSubArbol(TreeSet<Animal> arbol) {
        int cont = 1;
        String cod1, cod2;
        int pos1 = 0, pos2 = 0;
        Animal a1 = null, a2 = null, aux;
        SortedSet<Animal> subArbol;

        if (!arbol.isEmpty()) {
            cod1 = Teclado.next("Introduce la primera clave");
            cod2 = Teclado.next("Introduce la segunda clave");

            for (Animal a : arbol) {
                if (a.codigo.equals(cod1)) {
                    pos1 = cont;
                    a1 = a;
                } else if (a.codigo.equals(cod2)) {
                    pos2 = cont;
                    a2 = a;
                }
                cont++;
            }
            if (a1 != null || a2 != null) {
                if (pos1 > pos2) { //Compruebo que la posición de a1 sea mayor que la de a2, y si lo son los cambio
                    aux = a1;
                    a1 = a2;
                    a2 = aux;
                }
                subArbol = arbol.subSet(a1, true, a2, true); //Los booleans lo que hacen es incluir los objetos seleccionados por parámetros en el subárbol
                for (Animal a : subArbol)
                    System.out.println(a);

            } else
                System.out.println("ERROR, HAY UNA CLAVE INCORRECTA");
        } else
            System.out.println("EL MAPA ESTÁ VACÍO");
    }
}
