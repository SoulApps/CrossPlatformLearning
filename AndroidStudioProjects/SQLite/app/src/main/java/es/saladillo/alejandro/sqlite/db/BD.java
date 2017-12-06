package es.saladillo.alejandro.sqlite.db;

import android.provider.BaseColumns;

/**
 * Created by Alejandro on 03/02/2017.
 */

public class BD {
    // Constantes generales de la BD.
    public static final String BD_NOMBRE = "bd";
    public static final int BD_VERSION = 1;

    // Tabla Alumno.
    public static abstract class Alumno implements BaseColumns {
        public static final String TABLA = "alumnos";
        public static final String NOMBRE = "nombre";
        public static final String EDAD = "edad";
        public static final String[] TODOS = new String[] { _ID, NOMBRE, EDAD };
        public static final String URI = "content://es.iessaladillo.instituto/alumnos";
    }

    // Constructor privado para que NO pueda instanciarse.
    private BD() {
    }
}
