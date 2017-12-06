package es.saladillo.alejandro.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnInsultar;
    private Adaptador adaptador;
    private ArrayList<String> alumnos;
    private ListView lstAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    public void initVistas() {
        lstAlumnos = (ListView) this.findViewById(R.id.lstAlumnos);
        btnInsultar = (Button) findViewById(R.id.btnInsultar);
        alumnos = new ArrayList<>();
        adaptador = new Adaptador(this, alumnos);

        lstAlumnos.setAdapter(adaptador);


        alumnos.add("Baldomero");
        alumnos.add("Germán Ginés");
        alumnos.add("Pepito");
        adaptador.notifyDataSetChanged();

        lstAlumnos.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnInsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = (String) lstAlumnos.getItemAtPosition(lstAlumnos.getCheckedItemPosition()) + " te destruyo";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });
    }

}

