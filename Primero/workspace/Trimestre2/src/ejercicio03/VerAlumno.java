package ejercicio03;

import teclado.EnumRango;
import teclado.Teclado;

/**
 * Created by Alejandro on 13/01/2016.
 */
public class VerAlumno {
    public static void main(String[] args) {
        Alumno a = new Alumno(Teclado.next("Introduce el nombre"), Teclado.nextInt("Introduce la matrícula"));

        a.ponNota(Teclado.nextDouble("Introduce la nota 1", 0, 10, EnumRango.AMBOSINCLUIDOS), Teclado.nextDouble("Introduce la nota 2", 0, 10, EnumRango.AMBOSINCLUIDOS));

        System.out.println(a);
        Teclado.pichita();
    }
}
