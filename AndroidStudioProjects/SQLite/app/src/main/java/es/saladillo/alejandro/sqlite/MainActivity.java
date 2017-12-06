package es.saladillo.alejandro.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

import es.saladillo.alejandro.sqlite.db.BD;
import es.saladillo.alejandro.sqlite.db.DAO;
import es.saladillo.alejandro.sqlite.db.models.Alumno;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private Adaptador adaptador;
    private ListView lstAlumnos;
    private Button btnAgregar;
    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        getSupportLoaderManager().initLoader(0, null, this);

        lstAlumnos = (ListView) this.findViewById(R.id.lstAlumnos);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        if (dao == null)
            dao = DAO.getInstance(this);
        SQLiteDatabase bd = dao.openWritableDatabase();

        adaptador = new Adaptador(this, (ArrayList<Alumno>) dao.getAllAlumnos());
        lstAlumnos.setAdapter(adaptador);

        // Si se ha abierto correctamente
        if(bd != null) {
            /*
            // Se ejecutan las instrucciones SQL deseadas.
            ContentValues registro = new ContentValues();
            registro.put(BD.Alumno.NOMBRE, "Baldomero");
            registro.put(BD.Alumno.EDAD, 18);
            bd.insert(BD.Alumno.TABLA, null, registro);

            registro = new ContentValues();
            registro.put(BD.Alumno.NOMBRE, "Germnán Ginés");
            registro.put(BD.Alumno.EDAD, 20);
            bd.insert(BD.Alumno.TABLA, null, registro);
            */

            adaptador.actualizar((ArrayList<Alumno>) dao.getAllAlumnos());

            // Se cierra la base de datos cuando ya no sea necesaria.
            bd.close();
        }


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AgregarActivity.class);
                startActivityForResult(intent, AgregarActivity.RC_AGREGAR);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AgregarActivity.RC_AGREGAR && resultCode == RESULT_OK) {
            adaptador.actualizar(dao.getAllAlumnos());
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new SimpleCursorLoader(this) {
            @Override
            protected Cursor getCursor() {
                return dao.queryAllAlumnos();
            }

            @Override
            protected Uri getUri() {
                return Uri.parse(BD.Alumno.URI);
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
