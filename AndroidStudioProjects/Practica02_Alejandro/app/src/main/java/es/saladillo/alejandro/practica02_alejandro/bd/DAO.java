package es.saladillo.alejandro.practica02_alejandro.bd;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Locale;

import es.saladillo.alejandro.practica02_alejandro.models.Alumno;
import es.saladillo.alejandro.practica02_alejandro.models.Visita;

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
    public long createAlumno(Alumno alumno) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares campo-valor para realizar la inserción.
        ContentValues valores = new ContentValues();
        valores.put(DbContract.Alumno.NOMBRE, alumno.getNombre());
        valores.put(DbContract.Alumno.TELEFONO, alumno.getTelefono());
        valores.put(DbContract.Alumno.EMAIL, alumno.getEmail());
        valores.put(DbContract.Alumno.EMPRESA, alumno.getEmpresa());
        valores.put(DbContract.Alumno.TUTOR, alumno.getTutor());
        valores.put(DbContract.Alumno.HORARIO, alumno.getHorario());
        valores.put(DbContract.Alumno.DIRECCION, alumno.getDireccion());
        valores.put(DbContract.Alumno.IMAGEN, alumno.getImagen());

        // Se realiza el insert
        long resultado = bd.insert(DbContract.Alumno.TABLA, null, valores);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Alumno.URI), null);
        // Se retorna el _id del alumno insertado o -1 si error.
        return resultado;
    }

    public boolean deleteAlumno(long id) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza el delete.
        long resultado = bd.delete(DbContract.Alumno.TABLA, DbContract.Alumno._ID + " = "
                + id, null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Alumno.URI), null);
        // Se retorna si se ha eliminado algún alumno.
        return resultado > 0;

    }

    public boolean updateAlumno(Alumno alumno) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares clave-valor con cada campo-valor.
        ContentValues valores = new ContentValues();
        valores.put(DbContract.Alumno.NOMBRE, alumno.getNombre());
        valores.put(DbContract.Alumno.TELEFONO, alumno.getTelefono());
        valores.put(DbContract.Alumno.EMAIL, alumno.getEmail());
        valores.put(DbContract.Alumno.EMPRESA, alumno.getEmpresa());
        valores.put(DbContract.Alumno.TUTOR, alumno.getTutor());
        valores.put(DbContract.Alumno.HORARIO, alumno.getHorario());
        valores.put(DbContract.Alumno.DIRECCION, alumno.getDireccion());
        valores.put(DbContract.Alumno.IMAGEN, alumno.getImagen());

        // Se realiza el update.
        long resultado = bd.update(DbContract.Alumno.TABLA, valores, DbContract.Alumno._ID
                + " = " + alumno.getId(), null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Alumno.URI), null);
        // Se retorna si ha actualizado algún alumno.
        return resultado > 0;

    }

    public Cursor queryAllAlumnos() {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza la consulta y se retorna el cursor.
        return  bd.query(DbContract.Alumno.TABLA, DbContract.Alumno.TODOS, null,
                null, null, null, DbContract.Alumno.NOMBRE);
    }

    public ArrayList<Alumno> getAllAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();
        // Se consultan todos los alumnos en la DbContract y obtiene un cursor.
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

    public static Alumno cursorToAlumno(Cursor cursorAlumno) {
        // Crea un objeto Alumno y guarda los valores provenientes
        // del registro actual del cursor.
        Alumno alumno = new Alumno(cursorAlumno.getLong(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno._ID)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.NOMBRE)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.TELEFONO)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.EMAIL)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.EMPRESA)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.TUTOR)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.HORARIO)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.DIRECCION)),
                                    cursorAlumno.getString(cursorAlumno.getColumnIndexOrThrow(DbContract.Alumno.IMAGEN)
                                    )
        );
        // Se retorna el objeto Alumno.
        return alumno;
    }


    //Visita
    public long createVisita(Visita visita) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares campo-valor para realizar la inserción.
        ContentValues valores = new ContentValues();
        valores.put(DbContract.Visita.ALUMNO, visita.getIdAlumno());
        valores.put(DbContract.Visita.FECHA, visita.getFecha());
        valores.put(DbContract.Visita.HORA_INICIO, visita.getHoraInicio());
        valores.put(DbContract.Visita.HORA_FIN, visita.getHoraFin());
        valores.put(DbContract.Visita.RESUMEN, visita.getResumen());

        // Se realiza el insert
        long resultado = bd.insert(DbContract.Visita.TABLA, null, valores);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Visita.URI), null);
        // Se retorna el _id del alumno insertado o -1 si error.
        return resultado;
    }

    public boolean deleteVisita(long id) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza el delete.
        long resultado = bd.delete(DbContract.Visita.TABLA, DbContract.Visita._ID + " = "
                + id, null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica a quien observe la misma URI.
        mContentResolver.notifyChange(
               Uri.parse(DbContract.Visita.URI), null);
        // Se retorna si se ha eliminado algún alumno.
        return resultado > 0;

    }

    public boolean updateVisita(Visita visita) {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se crea la lista de pares clave-valor con cada campo-valor.
        ContentValues valores = new ContentValues();
        valores.put(DbContract.Visita.ALUMNO, visita.getIdAlumno());
        valores.put(DbContract.Visita.FECHA, visita.getFecha());
        valores.put(DbContract.Visita.HORA_INICIO, visita.getHoraInicio());
        valores.put(DbContract.Visita.HORA_FIN, visita.getHoraFin());
        valores.put(DbContract.Visita.RESUMEN, visita.getResumen());


        // Se realiza el update.
        long resultado = bd.update(DbContract.Visita.TABLA, valores, DbContract.Visita._ID
                + " = " + visita.getId(), null);
        // Se cierra la base de datos.
        mHelper.close();
        // Se notifica.
        mContentResolver.notifyChange(
                Uri.parse(DbContract.Visita.URI), null);
        // Se retorna si ha actualizado algún alumno.
        return resultado > 0;

    }

    public Cursor queryAllVisitass() {
        // Se abre la base de datos.
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        // Se realiza la consulta y se retorna el cursor.
        return  bd.query(DbContract.Visita.TABLA, DbContract.Visita.TODOS, null,
                null, null, null, DbContract.Visita.FECHA);
    }

    public ArrayList<Visita> getAllVisitas() {
        ArrayList<Visita> lista = new ArrayList<>();
        // Se consultan todos los alumnos en la DbContract y obtiene un cursor.
        Cursor cursor = this.queryAllVisitass();
        if (cursor != null) {
            lista = cursorToVisitas(cursor);
        }
        // Se cierra el cursor (IMPORTANTE).
        //cursor.close(); //Ya no
        // Se cierra la base de datos.
        mHelper.close();
        // Se retorna la lista.
        return lista;
    }

    public ArrayList<Visita> cursorToVisitas(Cursor cursor) {
        ArrayList<Visita> lista = new ArrayList<>();
        // Se convierte cada registro del cursor en un elemento de la lista.
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Visita visita = cursorToVisita(cursor);
            lista.add(visita);
            cursor.moveToNext();
        }
        // Se retorna la lista.
        return lista;
    }

    public static Visita cursorToVisita(Cursor cursorVisita) {
        // Crea un objeto Alumno y guarda los valores provenientes
        // del registro actual del cursor.
        Visita visita = new Visita(cursorVisita.getLong(cursorVisita.getColumnIndexOrThrow(DbContract.Visita._ID)),
                cursorVisita.getLong(cursorVisita.getColumnIndexOrThrow(DbContract.Visita.ALUMNO)),
                cursorVisita.getLong(cursorVisita.getColumnIndexOrThrow(DbContract.Visita.FECHA)),
                cursorVisita.getString(cursorVisita.getColumnIndexOrThrow(DbContract.Visita.HORA_INICIO)),
                cursorVisita.getString(cursorVisita.getColumnIndexOrThrow(DbContract.Visita.HORA_FIN)),
                cursorVisita.getString(cursorVisita.getColumnIndexOrThrow(DbContract.Visita.RESUMEN)
                )
        );
        // Se retorna el objeto Visita.
        return visita;
    }

    public ArrayList<Visita> selectVisitas(Alumno alumno) {
        ArrayList<Visita> resultado;
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        Cursor cursor = bd.rawQuery(String.format(Locale.getDefault(), "SELECT * FROM visita WHERE alumno = %d;", alumno.getId()), new String[0]);
        resultado = cursorToVisitas(cursor);
        mHelper.close();
        return resultado;
    }

    public Alumno getAlumnoFromVisita(Visita visita) {
        Alumno alumno = null;
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        Cursor cursor;
        cursor = bd.rawQuery(String.format(Locale.getDefault(), "SELECT * FROM alumno WHERE _id = %d;", visita.getIdAlumno()), new String[0]);
        if (cursorToAlumnos(cursor).size() > 0)
            alumno = cursorToAlumnos(cursor).get(0);
        mHelper.close();
        return alumno;
    }

    public ArrayList<Object[]> selectProximasVisitas() {
        ArrayList<Object[]> resultado = new ArrayList<>();
        SQLiteDatabase bd = mHelper.getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT a.nombre, a.imagen, MAX(v.fecha) FROM alumno a LEFT JOIN visita v ON v.alumno = a._id GROUP BY a._id;", new String[0]);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Object[] aux = {cursor.getString(cursor.getColumnIndexOrThrow(DbContract.Alumno.NOMBRE)), cursor.getString(cursor.getColumnIndexOrThrow(DbContract.Alumno.IMAGEN)), cursor.getLong(2)};
            resultado.add(aux);
            cursor.moveToNext();
        }
        cursor.close();
        mHelper.close();
        return resultado;
    }
}
