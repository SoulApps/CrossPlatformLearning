package es.saladillo.alejandro.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    public static final String PUNTUACION = "PUNTUACIÓN";

    private int puntos;
    private int totalPreguntas;
    private ArrayList<Pregunta> preguntas;
    private ArrayList<String> respuestas = new ArrayList<>();
    private Pregunta pregunta;
    private AdaptadorRespuestas adaptadorRespuestas;

    private Button btnComprobar;
    private TextView txtPregunta;
    private TextView txtContadorPregunta;
    private ListView lstRespuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initVistas();
    }

    private void initVistas() {
        btnComprobar = (Button) findViewById(R.id.btnComprobar);
        lstRespuestas = (ListView) findViewById(R.id.lstRespuestas);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtContadorPregunta = (TextView) findViewById(R.id.txtContadorPreguntas);

        puntos = 0;
        adaptadorRespuestas = new AdaptadorRespuestas(this, respuestas);
        preguntas = addDefaultPreguntas();
        totalPreguntas = preguntas.size();
        adaptadorRespuestas.notifyDataSetChanged();
        lstRespuestas.setAdapter(adaptadorRespuestas);
        lstRespuestas.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        mostrarPregunta(); //Muestro la primera pregunta.

        //Activo el botón cuando selecciona una respuesta.
        lstRespuestas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btnComprobar.setVisibility(View.VISIBLE);
            }
        });

        //Botón de comprobar.
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicion = lstRespuestas.getCheckedItemPosition();
                String respuesta = (String) lstRespuestas.getItemAtPosition(posicion);

                //Si es correcta muestra la siguiente pregunta y suma 1 a la puntuación.
                if (TextUtils.equals(respuesta, pregunta.getRespuestaCorrecta())) {
                    Toast.makeText(QuizActivity.this, "+1", Toast.LENGTH_SHORT).show();
                    puntos++;
                    lstRespuestas.clearChoices();
                    mostrarPregunta();
                }
                //Si no, entonces se acaba la partida y se iniciará la actividad con la nueva puntuación.
                else {
                    Toast.makeText(QuizActivity.this, "GAME OVER", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizActivity.this, ScoresActivity.class);
                    intent.putExtra(PUNTUACION, new Puntuacion(puntos));
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    //Creación de preguntas.
    private ArrayList<Pregunta> addDefaultPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        String[] respuestas = new String[4];

        respuestas[0] = "Cookiezi";
        respuestas[1] = "Rafis";
        respuestas[2] = "CookEasy";
        respuestas[3] = "Angelsim";
        preguntas.add(new Pregunta("¿Quién es el mejor jugador de osu!Standard?", respuestas, "Cookiezi"));

        respuestas[0] = "Angelsim";
        respuestas[1] = "Wilchq";
        respuestas[2] = "Doomsday";
        respuestas[3] = "Cookiezi";
        preguntas.add(new Pregunta("¿Quién es el mejor jugador de osu!Standard con ratón?", respuestas, "Angelsim"));

        respuestas[0] = "Blue zenith";
        respuestas[1] = "Dan dan";
        respuestas[2] = "Freedom dive";
        respuestas[3] = "Everything will freeze";
        preguntas.add(new Pregunta("¿Cuál es el mapa que más PP ha dado en osu!Standard?", respuestas, "Freedom dive"));

        respuestas[0] = "Maniera";
        respuestas[1] = "Infinity overdrive";
        respuestas[2] = "Freedom dive";
        respuestas[3] = "AiAe";
        preguntas.add(new Pregunta("¿Qué mapa tiene la mayor dificultad en osu!mania?", respuestas, "Maniera"));

        respuestas[0] = "rrtyui";
        respuestas[1] = "ExpertBot";
        respuestas[2] = "hvick225";
        respuestas[3] = "Cookiezi";
        preguntas.add(new Pregunta("¿Quién es el número 1 en The big black?", respuestas, "ExpertBot"));

        respuestas[0] = "Blue zenith";
        respuestas[1] = "Koukou no sousei";
        respuestas[2] = "Masterpiece";
        respuestas[3] = "With a dance number";
        preguntas.add(new Pregunta("¿En qué mapa fue baneado Cookiezi?", respuestas, "Masterpiece"));

        respuestas[0] = "Skystar";
        respuestas[1] = "Monstrata";
        respuestas[2] = "rrtyui";
        respuestas[3] = "xChippy";
        preguntas.add(new Pregunta("¿Quién hace los mapas más confusos?", respuestas, "Monstrata"));

        respuestas[0] = "sayonara-bye";
        respuestas[1] = "Reimu-Desu";
        respuestas[2] = "eLy";
        respuestas[3] = "My aim sucks";
        preguntas.add(new Pregunta("¿Cuál es el nombre actual de HDHR?", respuestas, "My aim sucks"));

        respuestas[0] = "ExGon";
        respuestas[1] = "Gon";
        respuestas[2] = "Dusk";
        respuestas[3] = "Chara";
        preguntas.add(new Pregunta("¿Cuál es el jugador más famoso de osu!ctb?", respuestas, "ExGon"));

        respuestas[0] = "Angelsim";
        respuestas[1] = "AngeLAqua";
        respuestas[2] = "Reimu-desu";
        respuestas[3] = "Asuna";
        preguntas.add(new Pregunta("¿Cuál fue el nombre original de AngeLMegunm1n?", respuestas, "Angelsim"));

        respuestas[0] = "jhlee0133";
        respuestas[1] = "jakads";
        respuestas[2] = "maskeara";
        respuestas[3] = "Snow Wind";
        preguntas.add(new Pregunta("¿Quién es el mejor jugador de osu!mania?", respuestas, "jakads"));

        respuestas[0] = "Corea del Sur";
        respuestas[1] = "Japón";
        respuestas[2] = "Estados Unidos";
        respuestas[3] = "China";
        preguntas.add(new Pregunta("¿Cuás es el país más alto en el ranking?", respuestas, "Estados Unidos"));

        respuestas[0] = "Nintendo DS";
        respuestas[1] = "Android";
        respuestas[2] = "iOS";
        respuestas[3] = "PS Vita";
        preguntas.add(new Pregunta("¿En el juego de qué plataforma se basó osu!?", respuestas, "Nintendo DS"));

        respuestas[0] = "1337";
        respuestas[1] = "1125";
        respuestas[2] = "2045";
        respuestas[3] = "368";
        preguntas.add(new Pregunta("¿Cuál es el máximo combo de The big black?", respuestas, "1337"));

        respuestas[0] = "Taiwán";
        respuestas[1] = "China";
        respuestas[2] = "Japón";
        respuestas[3] = "Corea del Sur";
        preguntas.add(new Pregunta("¿En qué país compite Cookiezi?", respuestas, "Corea del Sur"));

        return preguntas;
    }

    //Muestra una pregunta.
    private void mostrarPregunta() {
        boolean preguntaRepetida;
        int n;
        Random rnd = new Random();

        //Si existe la muestra.
        if (preguntas.size() != 0) {
            do {
                //Mostrará una que no se haya preguntado antes aleatoriamente.
                preguntaRepetida = false;
                n = rnd.nextInt(preguntas.size());
                pregunta = preguntas.get(n);
                //Si ya se ha mostrado.
                if (pregunta == null) {
                    preguntaRepetida = true;
                } else {
                    int preguntaActual = puntos + 1;
                    txtContadorPregunta.setText(getString(R.string.de, String.valueOf(preguntaActual), String.valueOf(totalPreguntas)));
                    btnComprobar.setVisibility(View.INVISIBLE); //Oculta el botón de comprobar.
                    txtPregunta.setText(pregunta.getPregunta());
                    adaptadorRespuestas.clear();
                    adaptadorRespuestas.addAll(pregunta.getRespuestas());
                    preguntas.remove(n); //Se elimina para que no se vuelva a mostrar.
                }
            } while (preguntaRepetida);
        }
        //Si no, se abre a actividad de records con la nueva puntuación.
        else {
            Intent intent = new Intent(QuizActivity.this, ScoresActivity.class);
            intent.putExtra(PUNTUACION, new Puntuacion(puntos));
            startActivity(intent);
            finish();
        }
    }
}
