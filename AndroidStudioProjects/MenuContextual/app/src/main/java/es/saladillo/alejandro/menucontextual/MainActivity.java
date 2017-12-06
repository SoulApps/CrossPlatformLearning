package es.saladillo.alejandro.menucontextual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int RC_NUEVO = 1;
    private static final int RC_EDICION = 2;
    private TextView lblEmpty;
    private ListView lstAlumnos;
    private Button btnAgregar;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    public void initVistas() {
        lblEmpty = (TextView) findViewById(R.id.lblEmpty);
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        adaptador = new Adaptador(MainActivity.this, BaseDatos.getAlumnos());

        lstAlumnos.setEmptyView(lblEmpty);
        lstAlumnos.setAdapter(adaptador);

        //Este método es el que gestiona la lista cuando hago el long click.
        configurarAlumno();

        adaptador.add(new Alumno(R.drawable.avatar, "Baldomero", 20, true));
        adaptador.add(new Alumno(R.drawable.avatar, "Germán Ginés", 20, true));
        adaptador.add(new Alumno(R.drawable.avatar, "Pepito", 187, false));


        lstAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Formulario.startForResult(MainActivity.this, 2, i, (Alumno) adaptador.getItem(i));
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Formulario.startForResult(MainActivity.this, 1);
            }
        });
    }

    private void configurarAlumno() {
        lstAlumnos.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lstAlumnos.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                String mensaje = "";
                ArrayList<Alumno> elementos;
                switch (item.getItemId()) {
                    case R.id.mnuInsultar:
                        elementos = getElementosSeleccionados(lstAlumnos, false);
                        for (Alumno elemento : elementos)
                            mensaje = mensaje + elemento.nombre + " ";

                        mensaje += "me acuerdo de vosotros";
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mnuEliminar:
                        elementos = getElementosSeleccionados(lstAlumnos, true);
                        for (Alumno elemento : elementos) {
                            mensaje = mensaje + elemento.nombre + " ";
                            adaptador.remove(elemento);
                        }
                        mensaje += "eliminados";
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                mode.setTitle(getString(R.string.de, lstAlumnos.getCheckedItemCount(), lstAlumnos.getCount()));
            }
        });
    }

    private ArrayList<Alumno> getElementosSeleccionados(ListView lista, boolean uncheck) {
        int i, position;
        ArrayList<Alumno> datos = new ArrayList<>();
        SparseBooleanArray seleccionados = lista.getCheckedItemPositions();

        for (i = 0; i < seleccionados.size(); i++) {
            // Si está seleccionado.
            if (seleccionados.valueAt(i)) {
                position = seleccionados.keyAt(i);
                // Se quita de la selección (si hay que hacerlo).
                if (uncheck) {
                    lista.setItemChecked(position, false);
                }
                // Se añade al resultado.
                datos.add((Alumno) lista.getItemAtPosition(seleccionados.keyAt(i)));
            }
        }

        return datos;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_NUEVO && resultCode == RESULT_OK) {
            adaptador.notifyDataSetChanged();
        } else if (requestCode == RC_EDICION && resultCode == RESULT_OK) {
            adaptador.notifyDataSetChanged();
        }
    }
}
