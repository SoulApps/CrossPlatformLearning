package es.saladillo.alejandro.json.events;

import java.util.ArrayList;

import es.saladillo.alejandro.json.models.Alumno;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class GetEvent {

    private ArrayList<Alumno> resultado;

    public GetEvent(ArrayList<Alumno> resultado) {
        this.resultado = resultado;
    }

    public ArrayList<Alumno> getResultado() {
        return resultado;
    }
}
