package es.saladillo.alejandro.menupopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lst;
    private Alumno datos[];
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    public void initVistas() {
        lst = (ListView) findViewById(R.id.activity_main);
        datos = new Alumno[] {new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, false), new Alumno("Pipiolo2", 20, false), new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, false), new Alumno("Pipiolo1", 18, false), new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, false), new Alumno("Pipiolo2", 20, false), new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, true), new Alumno("Pipiolo1", 18, false), new Alumno("Pipiolo1", 18, false), new Alumno("Pipiolo1", 188, true)};
        adaptador = new Adaptador(this, datos);
        lst.setAdapter(adaptador);
    }
}
