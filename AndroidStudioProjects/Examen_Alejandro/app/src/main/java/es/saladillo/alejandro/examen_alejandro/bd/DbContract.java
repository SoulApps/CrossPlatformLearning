package es.saladillo.alejandro.examen_alejandro.bd;

import android.provider.BaseColumns;

/**
 * Created by Alejandro on 03/02/2017.
 */

public class DbContract {
    // Constantes generales de la DbContract.
    public static final String BD_NOMBRE = "bd";
    public static final int BD_VERSION = 1;

    // Tabla Alumno.
    public static abstract class Libro implements BaseColumns {
        public static final String TABLA = "libro";
        public static final String TITULO = "titulo";
        public static final String AUTOR = "autor";
        public static final String PUBLICACION = "publicacion";
        public static final String PORTADA = "portada";
        public static final String SINOPSIS = "sinopsis";
        public static final String[] TODOS = new String[] { _ID, TITULO, AUTOR, PUBLICACION, PORTADA, SINOPSIS };
        public static final String URI = "content://es.iessaladillo.bd/libro";
    }

    // Constructor privado para que NO pueda instanciarse.
    private DbContract() {
    }
}
