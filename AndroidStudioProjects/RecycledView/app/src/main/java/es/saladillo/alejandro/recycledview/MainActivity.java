package es.saladillo.alejandro.recycledview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador.OnItemClickListener {

    private Adaptador adaptador;
    private ArrayList<Alumno> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        RecyclerView lstAlumnos = (RecyclerView) findViewById(R.id.lstAlumnos);
        datos.add(new Alumno("Pipiolo1", 18)); datos.add(new Alumno("Pipiolo2", 20)); datos.add(new Alumno("Pipiolo3", 18));
        lstAlumnos.setHasFixedSize(true);
        adaptador = new Adaptador(datos);
        adaptador.setOnItemClickListener(this);
        lstAlumnos.setAdapter(adaptador);
        lstAlumnos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lstAlumnos.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onItemClick(View view, Alumno alumno, int position) {
        datos.remove(position);
        adaptador.notifyItemRemoved(position);
    }
}
