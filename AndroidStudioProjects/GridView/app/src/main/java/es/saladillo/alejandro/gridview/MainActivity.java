package es.saladillo.alejandro.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView grdAlbumes;
    private ArrayList<Concepto> conceptos;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        grdAlbumes = (GridView) findViewById(R.id.grdAlbumes);

        conceptos = new ArrayList<>();
        conceptos.add(new Concepto(R.drawable.caballo, "Caballo", "Horse"));
        conceptos.add(new Concepto(R.drawable.cerdo, "Cerdo", "Pig"));
        conceptos.add(new Concepto(R.drawable.ciervo, "Ciervo", "Deer"));
        conceptos.add(new Concepto(R.drawable.gato, "Gato", "Cat"));
        conceptos.add(new Concepto(R.drawable.gorila, "Gorila", "Gorilla"));
        conceptos.add(new Concepto(R.drawable.jirafa, "Jirafa", "Giraffe"));
        conceptos.add(new Concepto(R.drawable.perro, "Perro", "Dog"));
        conceptos.add(new Concepto(R.drawable.tigre, "Tigre", "Tiger"));

        adaptador = new Adaptador(this, conceptos);
        grdAlbumes.setAdapter(adaptador);


        grdAlbumes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Concepto concepto = (Concepto) grdAlbumes.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, concepto.getEnglish(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
