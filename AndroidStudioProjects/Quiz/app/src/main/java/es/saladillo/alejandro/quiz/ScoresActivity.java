package es.saladillo.alejandro.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        initVistas();
    }

    private void initVistas() {
        ListView lstPuntuaciones = (ListView) findViewById(R.id.lstPuntuaciones);
        AdaptadorPuntuaciones adaptadorPuntuaciones = new AdaptadorPuntuaciones(this, Puntuaciones.getPuntuaciones());

        lstPuntuaciones.setEmptyView(findViewById(R.id.lblVacio));
        lstPuntuaciones.setAdapter(adaptadorPuntuaciones);

        //Escribe la nueva puntuación.
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Puntuacion puntos = extras.getParcelable(QuizActivity.PUNTUACION);
                adaptadorPuntuaciones.add(puntos);
            }
        }
    }
}
