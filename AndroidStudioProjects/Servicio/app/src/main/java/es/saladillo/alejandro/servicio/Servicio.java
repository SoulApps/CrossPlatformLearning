package es.saladillo.alejandro.servicio;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

public class Servicio extends IntentService {
    public Servicio() {
        super("Mi intent service"); //En IntentService-
    }

    //Si fuese un Service, entonces aquí iría la tarea.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY;
    }

    //Del Service
    /*@Override
    public IBinder onBind(Intent intent) {
        return null;
    }*/


    //Del IntentService.
    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(3000);
            Intent respuestaIntent = new Intent(MainActivity.ACTION_EXPORTADO);
            LocalBroadcastManager.getInstance(this).sendBroadcast(respuestaIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
