package es.saladillo.alejandro.examen_alejandro.bd;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.ArrayList;

import es.saladillo.alejandro.examen_alejandro.models.Libro;

/**
 * Created by Alejandro on 04/02/2017.
 */

public class DAO {

    private static DAO sInstance;

    private final SQLiteHelper mHelper; // Ayudante para la creación y gestión de la DbContract.
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

    //Alumno
    public long createLibro(Libro libro) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares campo-valor para realizar la inserción.
        ContentValues valores = new ContentValues();
        valores.put(DbContract.Libro.TITULO, libro.getTitulo());
        valores.put(DbContract.Libro.AUTOR, libro.getAutor());
        valores.put(DbContract.Libro.PUBLICACION, libro.getPublicacion());
        valores.put(DbContract.Libro.PORTADA, libro.getPortada());
        valores.put(DbContract.Libro.SINOPSIS, libro.getSinopsis());

        // Se realiza el insert
        long resultado = bd.insert(DbContract.Libro.TABLA, null, valores);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Libro.URI), null);
        // Se retorna el _id del alumno insertado o -1 si error.
        return resultado;
    }

    public boolean deleteLibro(long id) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza el delete.
        long resultado = bd.delete(DbContract.Libro.TABLA, DbContract.Libro._ID + " = "
                + id, null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Libro.URI), null);
        // Se retorna si se ha eliminado algún alumno.
        return resultado > 0;

    }

    public boolean updateLibro(Libro libro) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares clave-valor con cada campo-valor.
        ContentValues valores = new ContentValues();
        valores.put(DbContract.Libro.TITULO, libro.getTitulo());
        valores.put(DbContract.Libro.AUTOR, libro.getAutor());
        valores.put(DbContract.Libro.PUBLICACION, libro.getPublicacion());
        valores.put(DbContract.Libro.PORTADA, libro.getPortada());
        valores.put(DbContract.Libro.SINOPSIS, libro.getSinopsis());

        // Se realiza el update.
        long resultado = bd.update(DbContract.Libro.TABLA, valores, DbContract.Libro._ID
                + " = " + libro.getId(), null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Libro.URI), null);
        // Se retorna si ha actualizado algún alumno.
        return resultado > 0;

    }

    public Cursor queryAllLibros() {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza la consulta y se retorna el cursor.
        return  bd.query(DbContract.Libro.TABLA, DbContract.Libro.TODOS, null,
                null, null, null, DbContract.Libro.TITULO);
    }

    public ArrayList<Libro> getAllLibros() {
        ArrayList<Libro> lista = new ArrayList<>();
        // Se consultan todos los alumnos en la DbContract y obtiene un cursor.
        Cursor cursor = this.queryAllLibros();
        if (cursor != null) {
            lista = cursorToLibros(cursor);
        }
        // Se cierra el cursor (IMPORTANTE).
        //cursor.close(); //Ya no
        // Se cierra la base de datos.
        mHelper.close();
        // Se retorna la lista.
        return lista;
    }

    public ArrayList<Libro> cursorToLibros(Cursor cursor) {
        ArrayList<Libro> lista = new ArrayList<>();
        // Se convierte cada registro del cursor en un elemento de la lista.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Libro libro = cursorToLibro(cursor);
            lista.add(libro);
            cursor.moveToNext();
        }
        // Se retorna la lista.
        return lista;
    }

    public static Libro cursorToLibro(Cursor cursorLibro) {
        // Crea un objeto Alumno y guarda los valores provenientes
        // del registro actual del cursor.
        Libro libro = new Libro(cursorLibro.getLong(cursorLibro.getColumnIndexOrThrow(DbContract.Libro._ID)),
                                    cursorLibro.getString(cursorLibro.getColumnIndexOrThrow(DbContract.Libro.TITULO)),
                                    cursorLibro.getString(cursorLibro.getColumnIndexOrThrow(DbContract.Libro.AUTOR)),
                                    cursorLibro.getInt(cursorLibro.getColumnIndexOrThrow(DbContract.Libro.PUBLICACION)),
                                    cursorLibro.getString(cursorLibro.getColumnIndexOrThrow(DbContract.Libro.PORTADA)),
                                    cursorLibro.getString(cursorLibro.getColumnIndexOrThrow(DbContract.Libro.SINOPSIS))
        );
        // Se retorna el objeto Alumno.
        return libro;
    }
}
