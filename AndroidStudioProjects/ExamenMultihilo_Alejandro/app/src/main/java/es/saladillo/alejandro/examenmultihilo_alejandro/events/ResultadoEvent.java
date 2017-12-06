package es.saladillo.alejandro.examenmultihilo_alejandro.events;

import es.saladillo.alejandro.examenmultihilo_alejandro.models.Resultado;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class ResultadoEvent {

    private Resultado resultado;

    public ResultadoEvent(Resultado resultado) {
        this.resultado = resultado;
    }

    public Resultado getResultado() {
        return resultado;
    }
}
