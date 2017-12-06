package examenHerencia;

import teclado.EnumRango;
import teclado.Teclado;

import java.util.Arrays;

/**
 * Created by Alejandro on 06/03/2016.
 */
public class IesSaladillo {
    public static void main(String[] args) {
        final byte TAMANO = 6;
        int i;

        Alumno nombreIncorrecto;
        Alumno a1 = null, a2 = null, a3 = null; //Los inicializo a null por el try catch.
        Profesor p1 = null, p2 = null, p3 = null; //Los inicializo a null por el try catch.
        Personable array[] = new Personable[TAMANO];
        Personable arrayClonado[] = new Personable[TAMANO];

        //1.- Alumno con nombre incorrecto.
        System.out.println("-----------APARTADO 1-----------");
        try {
            //nombreIncorrecto = new Alumno("AleJandro Sánchez Galvín"); //Incorrecto
            //nombreIncorrecto = new Alumno("Alejandro José Sánchez Galvín"); //Incorrecto
            nombreIncorrecto = new Alumno("Alejandro Sánchez Galvín"); //Correcto
            //nombreIncorrecto = new Alumno("Alejandro josé Sánchez Galvín"); //Correcto
        } catch (NombreIncorrectoException e) {
            System.out.println(e.getMessage());
        }


        //2.1.- Crear 3 alumnos y 3 profesores.
        try {
            a1 = new Alumno("Alejandro Sánchez Galvín");
            a2 = new Alumno("José luis Moreno Nomeacuerdodelotroapellido");
            a3 = new Alumno("Laura Calvente Nomeacuerdodelotroapellido");

            p1 = new Profesor("Eva Peralta Nomeacuerdodelotroapellido", 5000);
            p2 = new Profesor("Ana Rodríguez Nomeacuerdodelotroapellido", 5000);
            p3 = new Profesor("José manuel Escribano Romero", 5000);
        } catch (NombreIncorrectoException e) {
            System.out.println(e.getMessage());
        }
        //2.2.- Meter 3 alumnos y 3 profesores en un array.
        array[0] = a1;
        array[1] = p1;
        array[2] = a2;
        array[3] = p2;
        array[4] = a3;
        array[5] = p3;


        //3.- Ejecutar tipo_numero() y toString().
        System.out.println("-----------APARTADO 3-----------");
        imprimirArray(array);


        //4.- Clono en el otro array.
        for (i = 0; i < TAMANO; i++)
            arrayClonado[i] = (Persona) ((Persona) array[i]).clone();


        //5.- Comparo con el equals los arrays.
        System.out.println("-----------APARTADO 5-----------");

        //Cambio opcional de nombre de un objeto para comprobar los equals.
        /*try {
            ((Alumno) array[0]).setNombre("Alesagal Sanchez Galvin");
        } catch (NombreIncorrectoException e) {
            System.out.println(e.getMessage());
        }*/

        System.out.println(compararArrays(array, arrayClonado)?"Los arrays son iguales" : "Los arrays no son iguales");


        //6.- Prueba del método de variables de interfaz.
        System.out.println("-----------APARTADO 6-----------");
        metodoParaVariablesInterfaz(arrayClonado);
        imprimirArray(arrayClonado); //Muestro el array clonado ya cambiado para comprobarlo.
        System.out.println(compararArrays(array, arrayClonado)?"Los arrays son iguales" : "Los arrays no son iguales");
    }

    //Método para comparar arrays usando el método equals de la clase Arrays.
    public static boolean compararArrays(Personable[] array, Personable[] arrayClonado) {
        boolean igual = true;
        int i;

        for (i = 0; i < array.length; i++) {
            if (!Arrays.equals(array, arrayClonado))
                igual = false;
        }

        return igual;
    }

    //Método para imprimir arrays y el orden creado.
    public static void imprimirArray(Personable[] personas) {
        int i;
        for (i = 0; i < personas.length; i++)
            System.out.printf("%s %s%n", ((Persona) personas[i]).tipo_numero(), personas[i]);
    }

    //Método del apartado 6.
    public static void metodoParaVariablesInterfaz(Personable[] personas) {
        int i;
        for (i = 0; i < personas.length; i++) {
            if (i % 2 == 0)
                personas[i].validar();
            if (personas[i] instanceof Alumnable)
                ((Alumnable) personas[i]).anhadirNota(Teclado.nextDouble("Introduce una nota nueva", 0, 10, EnumRango.AMBOSINCLUIDOS)); //Solo son validos números entre 0 y 10.
            if (personas[i] instanceof Profesorable)
                ((Profesorable) personas[i]).subirSueldo(((Profesor) personas[i]).getSueldo() * 0.10);
        }
    }
}
