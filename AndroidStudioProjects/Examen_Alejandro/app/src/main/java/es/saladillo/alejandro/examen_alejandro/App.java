package es.saladillo.alejandro.examen_alejandro;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Alejandro on 26/02/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
