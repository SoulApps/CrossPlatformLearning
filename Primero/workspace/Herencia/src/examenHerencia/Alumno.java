package examenHerencia;

import java.util.Arrays;

/**
 * Created by Alejandro on 07/03/2016.
 */
public class    Alumno extends Persona implements Alumnable {
    private static int numeroAlumnosCreados = 0;
    private final byte TAMANO = 5;
    private double notas[] = new double[TAMANO];
    private byte notasPuestas;
    private int numeroAlumno;

    public Alumno(String nombre) throws NombreIncorrectoException {
        super(nombre);
        numeroAlumnosCreados++;
        numeroAlumno = numeroAlumnosCreados;
        notasPuestas = 0;
    }

    public String tipo_numero() {
        return String.format("Soy el alumno número %d", numeroAlumno);
    }


    public void anhadirNota(double nota) {
        if (notasPuestas < TAMANO) {
            notas[notasPuestas] = nota;
            notasPuestas++;
        }
    }


    public Object clone() {
        int i;
        Alumno a;

        a = (Alumno) super.clone();
        a.notas = notas.clone();
        /*for (i = 0; i < TAMANO; i++)
            a.notas[i] = notas[i];*/

        return a;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Alumno)
            if (super.equals(o) && Arrays.equals(notas, ((Alumno) o).notas))
                igual = true;

        return igual;
    }

    public String toString() {
        String stringNotas = "";
        int i;
        for (i = 0; i < notas.length; i++)
            stringNotas += String.format("[Nota %d: %.1f]", i + 1, notas[i]);

        return String.format("%s %s", super.toString(), stringNotas);
    }
}
