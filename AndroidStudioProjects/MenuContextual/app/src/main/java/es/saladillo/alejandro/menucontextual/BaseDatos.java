package es.saladillo.alejandro.menucontextual;

import java.util.ArrayList;

/**
 * Created by Saha on 08/11/2016.
 */

public class BaseDatos {
    static private ArrayList<Alumno> alumnos=new ArrayList<Alumno>();

    static {}

     public static  ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }
    public static void agregarAlumno(Alumno alumno){
        alumnos.add(alumno);
    }
    public static void eliminarAlumnos(int position){
        alumnos.remove(position);
    }
    public static void modificarAlumno(Alumno alumno, int position){
        alumnos.remove(position);
        alumnos.add(position,alumno);
    }


}
