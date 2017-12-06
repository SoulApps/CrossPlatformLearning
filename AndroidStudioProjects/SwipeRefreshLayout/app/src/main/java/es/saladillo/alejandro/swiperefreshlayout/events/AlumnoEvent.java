package es.saladillo.alejandro.swiperefreshlayout.events;

import es.saladillo.alejandro.swiperefreshlayout.models.Alumno;

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
