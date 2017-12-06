package es.saladillo.alejandro.listaalumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int RC_NUEVO = 1;
    private Button btnAgregar;
    private ListView lstAlumnos;
    private TextView lblNombre;
    private TextView lblEdad;
    private TextView lblRepetidor;
    private ImageView imgFoto;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        lstAlumnos = (ListView) findViewById(R.id.lstPersonas);
        lblNombre = (TextView) findViewById(R.id.lblNombre);

        lstAlumnos.setEmptyView(findViewById(R.id.lblVacio));
        adaptador = new Adaptador(this, BD.getAlumnos());
        lstAlumnos.setAdapter(adaptador);

        adaptador.add(new Alumno("prueba", 12, true, 0));

        lstAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView < ? > lst, View v,int position, long id){
                FormularioActivity.startForResult(MainActivity.this, RC_NUEVO, (Alumno) lstAlumnos.getItemAtPosition(position));
            }
        });

        lstAlumnos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                BD.eliminarAlumno(position);
                adaptador.notifyDataSetChanged();
                return true;
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormularioActivity.startForResult(MainActivity.this, RC_NUEVO);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_NUEVO && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                if (data.hasExtra("alumno")) {
                    Alumno alumno = data.getParcelableExtra("alumno");
                    BD.agregarAlumno(alumno);
                }
            }
        }
        adaptador.notifyDataSetChanged();
        adaptador.clear();
        adaptador.addAll(BD.getAlumnos());
    }

}
