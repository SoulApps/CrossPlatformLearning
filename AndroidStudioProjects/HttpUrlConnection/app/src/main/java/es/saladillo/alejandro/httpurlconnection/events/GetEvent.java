package es.saladillo.alejandro.httpurlconnection.events;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class GetEvent {

    private String resultado;

    public GetEvent(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}
