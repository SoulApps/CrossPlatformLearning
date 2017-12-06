package es.saladillo.alejandro.sqlite.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import es.saladillo.alejandro.sqlite.db.models.Alumno;

/**
 * Created by Alejandro on 04/02/2017.
 */

public class DAO {

    private static DAO sInstance;

    private final SQLiteHelper mHelper; // Ayudante para la creación y gestión de la BD.
    private final ContentResolver mContentResolver;

    // Constructor privado. Recibe el contexto.
    private DAO(Context contexto) {
        // Se obtiene el mHelper.
        mHelper = SQLiteHelper.getInstance(contexto);
        mContentResolver = contexto.getContentResolver();
    }

    // Retorna la instancia (única) del helper.
    public static synchronized DAO getInstance(Context context) {
        // Al usar el contexto de la aplicación nos aseguramos de que no haya
        // memory leaks si el recibido es el contexto de una actividad.
        if (sInstance == null) {
            sInstance = new DAO(context);
        }
        return sInstance;
    }

    // Abre la base de datos para escritura.
    public SQLiteDatabase openWritableDatabase() {
        return mHelper.getWritableDatabase();
    }

    // Cierra la base de datos.
    public void closeDatabase() {
        mHelper.close();
    }

    // CRUD (Create-Read-Update-Delete) de la tabla alumnos

    // Inserta un alumno en la tabla de alumnmos.
    // Recibe el objeto Alumno a insertar.
    // Retorna el _id del alumna una vez insertado o -1 si se ha producido un
    // error.
    public long createAlumno(Alumno alumno) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares campo-valor para realizar la inserción.
        ContentValues valores = new ContentValues();
        valores.put(BD.Alumno.NOMBRE, alumno.getNombre());
        valores.put(BD.Alumno.EDAD, alumno.getEdad());

        // Se realiza el insert
        long resultado = bd.insert(BD.Alumno.TABLA, null, valores);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
                Uri.parse(BD.Alumno.URI), null);
        // Se retorna el _id del alumno insertado o -1 si error.
        return resultado;
    }

    // Borra de la BD un alumno. Recibe el _id del alumno a borrar. Retorna true
    // si se ha realizado la eliminación con éxito.
    public boolean deleteAlumno(long id) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza el delete.
        long resultado = bd.delete(BD.Alumno.TABLA, BD.Alumno._ID + " = "
                + id, null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        //mContentResolver.notifyChange(
        //        Uri.parse(Instituto.Alumno.URI), null);
        // Se retorna si se ha eliminado algún alumno.
        return resultado > 0;

    }

    // Actualiza en la BD los datos de un alumno. Recibe el alumno. Retorna true
    // si la actualización se ha realizado con éxito.
    public boolean updateAlumno(Alumno alumno) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares clave-valor con cada campo-valor.
        ContentValues valores = new ContentValues();
        valores.put(BD.Alumno.NOMBRE, alumno.getNombre());
        valores.put(BD.Alumno.EDAD, alumno.getEdad());

        // Se realiza el update.
        long resultado = bd.update(BD.Alumno.TABLA, valores, BD.Alumno._ID
                + " = " + alumno.getId(), null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica.
        mContentResolver.notifyChange(
                Uri.parse(BD.Alumno.URI), null);
        // Se retorna si ha actualizado algún alumno.
        return resultado > 0;

    }

    // Consulta en la BD los datos de un alumno. Recibe el _id del alumno a
    // consultar. Retorna el objeto Alumno o null si no existe.
    public Alumno queryAlumno(long id) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza la query SQL sobre la BD.
        Cursor cursor = bd.query(true, BD.Alumno.TABLA,
                BD.Alumno.TODOS, BD.Alumno._ID + " = " + id,
                null, null, null, null, null);
        // Se mueve al primer registro del cursor.
        Alumno alumno = null;
        if (cursor != null) {
            cursor.moveToFirst();
            // Retorno el objeto Alumno correspondiente.
            alumno = cursorToAlumno(cursor);
        }
        // Se cierra la base de datos.
        mHelper.close();
        // Se retorna el alumno o null.
        return alumno;
    }

    // Consulta en la BD todos los alumnos. Retorna el cursor resultado de la
    // consulta (puede ser null si no hay alumnos), ordenados alfabéticamente
    // por nombre.
    public Cursor queryAllAlumnos() {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza la consulta y se retorna el cursor.
        return  bd.query(BD.Alumno.TABLA, BD.Alumno.TODOS, null,
                null, null, null, BD.Alumno.NOMBRE);
    }

    // Consulta en la VD todos los alumnos. Retorna una lista de objeto Alumno,
    // ordenados alfabéticamente por nombre.
    public ArrayList<Alumno> getAllAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();
        // Se consultan todos los alumnos en la BD y obtiene un cursor.
        Cursor cursor = this.queryAllAlumnos();
        if (cursor != null) {
            lista = cursorToAlumnos(cursor);
        }
        // Se cierra el cursor (IMPORTANTE).
        //cursor.close(); //Ya no
        // Se cierra la base de datos.
        mHelper.close();
        // Se retorna la lista.
        return lista;
    }

    // Retorna un ArrayList construido a partir del recorrido de un cursor de alumnos.
    public ArrayList<Alumno> cursorToAlumnos(Cursor cursor) {
        ArrayList<Alumno> lista = new ArrayList<>();
        // Se convierte cada registro del cursor en un elemento de la lista.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Alumno alumno = cursorToAlumno(cursor);
            lista.add(alumno);
            cursor.moveToNext();
        }
        // Se retorna la lista.
        return lista;
    }

    // Crea un objeto Alumno a partir del registro actual de un cursor. Recibe
    // el cursor y retorna un nuevo objeto Alumno cargado con los datos del
    // registro actual del cursor.
    public static Alumno cursorToAlumno(Cursor cursorAlumno) {
        // Crea un objeto Alumno y guarda los valores provenientes
        // del registro actual del cursor.
        Alumno alumno = new Alumno();
        alumno.setId(cursorAlumno.getLong(
                cursorAlumno.getColumnIndexOrThrow(BD.Alumno._ID)));
        alumno.setNombre(cursorAlumno.getString(
                cursorAlumno.getColumnIndexOrThrow(BD.Alumno.NOMBRE)));
        alumno.setEdad(cursorAlumno.getInt(
                cursorAlumno.getColumnIndexOrThrow(BD.Alumno.EDAD)));
        // Se retorna el objeto Alumno.
        return alumno;
    }
}
