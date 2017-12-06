package es.saladillo.alejandro.httpurlconnection.events;

import android.app.IntentService;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import es.saladillo.alejandro.httpurlconnection.MainActivity;
import es.saladillo.alejandro.httpurlconnection.util.HttpManager;

/**
 * Created by Alejandro on 01/02/2017.
 */

public class PostService extends IntentService {

    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_FECHA = "fecha";

    public PostService() {
        super("PostService");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle args = intent.getExtras();
        if (args != null) {
            String nombre = args.getString(MainActivity.ARG_NOMBRE);
            HashMap<String, String> params = new HashMap<>();
            params.put(KEY_NOMBRE, nombre);
            params.put(KEY_FECHA, new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));

            String resultado = HttpManager.post("http://www.informaticasaladillo.es/echo.php", params);
            Log.d("aaa", resultado);
            EventBus.getDefault().post(new PostEvent(resultado));
        }
    }
}
