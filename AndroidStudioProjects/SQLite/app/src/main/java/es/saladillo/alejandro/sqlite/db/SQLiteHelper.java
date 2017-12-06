package es.saladillo.alejandro.sqlite.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.compat.BuildConfig;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Alejandro on 03/02/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ALUMNOS =
            "CREATE TABLE " + BD.Alumno.TABLA + " (" +
                    BD.Alumno._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    BD.Alumno.NOMBRE + " TEXT, " +
                    BD.Alumno.EDAD + " INTEGER" +
                    " )";
    // ... (sentencias SQL para el resto de tablas).

    // Instancia única.
    private static SQLiteHelper instance;

    // Constructor privado para que no se pueda instanciar desde fuera.
    private SQLiteHelper(Context contexto) {
        // Se llama al constuctor del padre.
        super(contexto, BD.BD_NOMBRE, null, BD.BD_VERSION);
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
        // ... (sentencias SQL del resto de tablas)
    }

    // Se llama automáticamente al intentar abrir una base de datos con una versión
    // distinta a la que tiene actualmente.
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        // Por simplicidad, se eliminan las tablas existentes y se vuelven a crear,
        db.execSQL("DROP TABLE IF EXISTS " + BD.Alumno.TABLA);
        db.execSQL(SQL_CREATE_ALUMNOS);
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
