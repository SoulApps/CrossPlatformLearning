package es.saladillo.alejandro.examenmultihilo_alejandro.events;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Locale;

import es.saladillo.alejandro.examenmultihilo_alejandro.Api;
import es.saladillo.alejandro.examenmultihilo_alejandro.MainActivity;
import es.saladillo.alejandro.examenmultihilo_alejandro.R;
import es.saladillo.alejandro.examenmultihilo_alejandro.models.Rates;
import es.saladillo.alejandro.examenmultihilo_alejandro.models.Resultado;
import es.saladillo.alejandro.examenmultihilo_alejandro.models.ResultadoApi;
import retrofit2.Call;
import retrofit2.Response;

import static android.support.v4.app.NotificationCompat.DEFAULT_LIGHTS;
import static android.support.v4.app.NotificationCompat.DEFAULT_SOUND;

/**
 * Created by Alejandro on 01/03/2017.
 */

public class PeticionService extends IntentService {

    public PeticionService() {
        super("PeticionService");
    }

    //Si fuese un Service, entonces aquí iría la tarea.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        float cantidad;
        String moneda, divisas;
        Response<ResultadoApi> response;
        ResultadoApi resultadoApi;
        Rates rates;
        Resultado resultado;
        Call<ResultadoApi> peticion;
        Api.ApiInterface apiInterface = Api.getApiInterface(this);
        Bundle extras = intent.getExtras();
        try {
            if (extras != null) {
                moneda = extras.getString(MainActivity.ARG_MONEDA);
                cantidad = extras.getFloat(MainActivity.ARG_CANTIDAD);
                divisas = extras.getString(MainActivity.ARG_DIVISAS);

                peticion = apiInterface.getMoneda(moneda, divisas);
                response = peticion.execute();
                resultadoApi = response.body();

                if (resultadoApi != null) {
                    rates = resultadoApi.getRates();

                    /*Creo un objeto resultado pasándole la cantidad de dinero cuyo cambio se quiere conocer
                    y las divisas, que calcula internamente en el constructor*/
                    resultado = new Resultado(cantidad, rates.getEUR(), rates.getGBP(), rates.getUSD(), rates.getJPY());

                    EventBus.getDefault().post(new ResultadoEvent(resultado));
                    notificar(rates, cantidad);
                } else
                    EventBus.getDefault().post(new ErrorEvent("Error"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            EventBus.getDefault().post(new ErrorEvent("Error"));
        }
    }

    private void notificar(Rates rates, float valor) {
        NotificationManager mGestor = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Se crea el constructor de notificaciones.
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        // Se configuran los elementos básicos de la notificación.
        b.setSmallIcon(R.mipmap.ic_launcher); // Icono pequeño.
        b.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap()); // Icono grande.
        b.setContentTitle("Información descargada"); // Título (1ª línea).
        b.setContentText(String.format(Locale.getDefault(), "%.2fEUR %.2fGPB %.2fUSD %.2fJPY", rates.getEUR() == null?valor:rates.getEUR(), rates.getGBP() == null?valor:rates.getGBP(), rates.getUSD() == null?valor:rates.getUSD(), rates.getJPY() == null?valor:rates.getJPY())); // Texto (2º línea).
        //b.setContentInfo("3"); // Info adicional (nº total tareas pendientes).
        b.setTicker("Información descargada");  // Ticker.

        //OnClick.
        b.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0));

        //Sonido y LED.
        b.setDefaults(DEFAULT_SOUND | DEFAULT_LIGHTS);//b.setDefaults(DEFAULT_ALL);

        //Desaparece al hacer click
        b.setAutoCancel(true);

        // Se construye y muestra la notificación, asignándole un código de notificación entero.
        mGestor.notify(0, b.build());
    }
}
