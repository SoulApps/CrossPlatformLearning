package es.saladillo.alejandro.practica02_alejandro.bd;

import android.provider.BaseColumns;

/**
 * Created by Alejandro on 03/02/2017.
 */

public class DbContract {
    // Constantes generales de la DbContract.
    public static final String BD_NOMBRE = "bd";
    public static final int BD_VERSION = 1;

    // Tabla Alumno.
    public static abstract class Alumno implements BaseColumns {
        public static final String TABLA = "alumno";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String EMAIL = "email";
        public static final String EMPRESA = "empresa";
        public static final String TUTOR = "tutor";
        public static final String HORARIO = "horario";
        public static final String DIRECCION = "direccion";
        public static final String IMAGEN = "imagen";
        public static final String[] TODOS = new String[] { _ID, NOMBRE, TELEFONO, EMAIL, EMPRESA, TUTOR, HORARIO, DIRECCION, IMAGEN };
        public static final String URI = "content://es.iessaladillo.bd/alumno";
    }

    //Tabla Visita
    public static abstract class Visita implements BaseColumns {
        public static final String TABLA = "visita";
        public static final String ALUMNO = "alumno";
        public static final String FECHA = "fecha";
        public static final String HORA_INICIO = "horaInicio";
        public static final String HORA_FIN = "horaFin";
        public static final String RESUMEN = "resumen";
        public static final String[] TODOS = new String[] { _ID, ALUMNO, FECHA, HORA_INICIO, HORA_FIN, RESUMEN };
        public static final String URI = "content://es.iessaladillo.bd/visita";
    }

    // Constructor privado para que NO pueda instanciarse.
    private DbContract() {
    }
}
