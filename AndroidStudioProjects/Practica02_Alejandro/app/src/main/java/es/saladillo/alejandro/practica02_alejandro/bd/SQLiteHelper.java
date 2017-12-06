package es.saladillo.alejandro.practica02_alejandro.bd;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by Alejandro on 03/02/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ALUMNOS =
            "CREATE TABLE " + DbContract.Alumno.TABLA + " (" +
                    DbContract.Alumno._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DbContract.Alumno.NOMBRE + " TEXT, " +
                    DbContract.Alumno.TELEFONO + " TEXT, " +
                    DbContract.Alumno.EMAIL + " TEXT, " +
                    DbContract.Alumno.EMPRESA + " TEXT, " +
                    DbContract.Alumno.TUTOR + " TEXT, " +
                    DbContract.Alumno.HORARIO + " TEXT, " +
                    DbContract.Alumno.DIRECCION + " TEXT, " +
                    DbContract.Alumno.IMAGEN + " TEXT" +
                    " )";
    private static final String SQL_CREATE_VISITAS =
            "CREATE TABLE " + DbContract.Visita.TABLA + " (" +
                    DbContract.Visita._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DbContract.Visita.ALUMNO + " INTEGER, " +
                    DbContract.Visita.FECHA + " INTEGER, " +
                    DbContract.Visita.HORA_INICIO + " TEXT, " +
                    DbContract.Visita.HORA_FIN + " TEXT, " +
                    DbContract.Visita.RESUMEN + " TEXT" +
                    " )";
    // Instancia única.
    private static SQLiteHelper instance;

    // Constructor privado para que no se pueda instanciar desde fuera.
    private SQLiteHelper(Context contexto) {
        // Se llama al constuctor del padre.
        super(contexto, DbContract.BD_NOMBRE, null, DbContract.BD_VERSION);
    }

    // Retorna la instancia única del helper.
    public synchronized static SQLiteHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new SQLiteHelper(ctx.getApplicationContext());
        }
        return instance;
    }

    // Se llama automáticamente al intentar abrir una base de datos que
    // no exista aún.
    @Override
    public void onCreate(SQLiteDatabase db) {
        // A partir de la API 16 se llama al método onConfigure().
        // Debe hacerse antes de crear las tablas.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            // Se activa el log de la base de datos
            db.enableWriteAheadLogging();
            if (!db.isReadOnly()) {
                // Se activa el uso de foreign keys en SQLite.
                db.execSQL("PRAGMA foreign_keys = ON;");
            }
        }
        // Se ejecutan las sentencias SQL de creación de las tablas.
        db.execSQL(SQL_CREATE_ALUMNOS);
        db.execSQL(SQL_CREATE_VISITAS);
    }

    // Se llama automáticamente al intentar abrir una base de datos con una versión
    // distinta a la que tiene actualmente.
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        // Por simplicidad, se eliminan las tablas existentes y se vuelven a crear,
        //db.execSQL("DROP TABLE IF EXISTS " + DbContract.Alumno.TABLA);
        //db.execSQL(SQL_CREATE_ALUMNOS);
        // ... (sentencias SQL del resto de tablas)
    }

    // Se llama automáticamente en API >= 16 para configurar la base de datos.
    @Override
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        // Se activa el log de la base de datos.
        setWriteAheadLoggingEnabled(true);
        // Se activa el uso de foreign keys en SQLite.
        db.setForeignKeyConstraintsEnabled(true);
    }
}
