package es.saladillo.alejandro.httpurlconnection.events;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class PostEvent {

    private String resultado;

    public PostEvent(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}
