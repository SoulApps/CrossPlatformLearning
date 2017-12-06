package es.saladillo.alejandro.listaalumnos;

import java.util.ArrayList;

/**
 * Created by Alejandro on 08/11/2016.
 */

public class BD {

    private static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public static void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public static void actualizarAlumno(Alumno alumno, int position) {
        alumnos.set(position, alumno);
    }

    public static void eliminarAlumno(int position) {
        alumnos.remove(position);
    }
}
