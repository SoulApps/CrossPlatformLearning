package com.example.saha.app014_listadealumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int RC_NUEVO = 1;
    private static final int RC_EDICION = 2;
    TextView lblEmpty;
    ListView lstAlumnos;
    Button btnAgregar;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }
    public void initVistas(){
        lblEmpty= (TextView) findViewById(R.id.lblEmpty);
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        btnAgregar= (Button) findViewById(R.id.btnAgregar);
        adaptador=new Adaptador(MainActivity.this,BaseDatos.getAlumnos());

        lstAlumnos.setEmptyView(lblEmpty);
        lstAlumnos.setAdapter(adaptador);

        adaptador.add(new Alumno(R.drawable.avatar, "Baldomero", 20, true));
        adaptador.add(new Alumno(R.drawable.avatar, "Germán Ginés", 20, true));

        lstAlumnos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Formulario.startForResult(MainActivity.this,2,i,(Alumno)adaptador.getItem(i));
                return true;
            }
        });
        lstAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adaptador.remove(adaptador.getItem(i));
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Formulario.startForResult(MainActivity.this,1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==RC_NUEVO && resultCode==RESULT_OK){
            adaptador.notifyDataSetChanged();
        }
        else if(requestCode==RC_EDICION && resultCode==RESULT_OK) {
            adaptador.notifyDataSetChanged();
        }
    }
}
