package es.saladillo.alejandro.eventbus.events;

import es.saladillo.alejandro.eventbus.models.Alumno;

/**
 * Created by Alejandro on 30/01/2017.
 */

public class AlumnoEvent {

    private Alumno alumno;

    public AlumnoEvent(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }
}
