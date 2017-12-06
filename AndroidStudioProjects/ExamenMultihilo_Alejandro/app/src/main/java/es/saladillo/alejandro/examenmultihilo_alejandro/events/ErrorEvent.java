package es.saladillo.alejandro.examenmultihilo_alejandro.events;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class ErrorEvent {

    private String error;

    public ErrorEvent(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
