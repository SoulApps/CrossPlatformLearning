package es.saladillo.alejandro.quiz;

/**
 * Created by Alejandro on 03/12/2016.
 */

public class Pregunta {

    private String pregunta;
    private String[] respuestas;
    private String respuestaCorrecta;

    public Pregunta(String pregunta, String[] respuestas, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestas = new String[respuestas.length];
        for (int i = 0; i < respuestas.length; i++)
            this.respuestas[i] = respuestas[i];
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
