package es.saladillo.alejandro.eventbus.events;

import android.app.IntentService;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import es.saladillo.alejandro.eventbus.models.Alumno;

public class Servicio extends IntentService {
    public Servicio() {
        super("Mi intent service"); //En IntentService
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
            EventBus.getDefault().post(new AlumnoEvent(new Alumno("Baldomero", 18)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
