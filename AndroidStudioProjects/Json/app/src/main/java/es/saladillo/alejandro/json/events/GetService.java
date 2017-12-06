package es.saladillo.alejandro.json.events;

import android.app.IntentService;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import es.saladillo.alejandro.json.models.Alumno;
import es.saladillo.alejandro.json.util.HttpManager;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class GetService extends IntentService {

    public GetService() {
        super("GetService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String resultado = HttpManager.get("https://dl.dropboxusercontent.com/u/67422/Android/json/datos.json");
        ArrayList<Alumno> alumnos = parseJson(resultado);
        EventBus.getDefault().post(new GetEvent(alumnos));
    }

    private ArrayList<Alumno> parseJson(String contenido) {
        Gson gson = new Gson();
        Type tipoListaAlumnos = new TypeToken<List<Alumno>>() {
        }.getType();
        // Se procesa la cadena JSON y se retorna.
        return gson.fromJson(contenido, tipoListaAlumnos);
    }
}
