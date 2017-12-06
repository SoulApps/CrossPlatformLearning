package es.saladillo.alejandro.okhttp.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import es.saladillo.alejandro.okhttp.MainActivity;
import es.saladillo.alejandro.okhttp.util.HttpManager;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class GetService extends IntentService {

    public GetService() {
        super("GetService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle args = intent.getExtras();
        if (args != null) {
            String nombre = args.getString(MainActivity.ARG_NOMBRE);
            String resultado = HttpManager.get("https://www.google.es/search?hl=es&q=", nombre);
            resultado = extractResultado(resultado);
            EventBus.getDefault().post(new GetEvent(resultado));
        }
    }

    private String extractResultado(String contenido) {
        String resultado = "";
        int ini = contenido.indexOf("Aproximadamente");
        if (ini != -1) {
            // Se busca el siguiente espacio en blanco después de
            // Aproximadamente.
            int fin = contenido.indexOf(" ", ini + 16);
            // El resultado corresponde a lo que sigue a
            // Aproximadamente, hasta el siguiente espacio en blanco.
            resultado = contenido.substring(ini + 16, fin);
        }
        return resultado;
    }

}
